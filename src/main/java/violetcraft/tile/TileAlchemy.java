package violetcraft.tile;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import violetcraft.registry.AlchemyRecipes;

import static violetcraft.tile.TileGenerator.testEE;

public class TileAlchemy extends TileEntity implements ISidedInventory
{

    private String field_145958_o;
    //燃焼時間
    public int burnTime;

    public int currentItemBurnTime;

    //精製量
    public int generatorAmount;
    public int amountEE;

    //調理時間
    public int cookTime;

    private static final int[] slots_top = new int[] {0};
    private static final int[] slots_bottom = new int[] {2, 1};
    private static final int[] slots_sides = new int[] {1};

    public ItemStack[] sampleItemStacks = new ItemStack[3];

    public void readFromNBT(NBTTagCompound ntbwriteread)
    {
        super.readFromNBT(ntbwriteread);
        NBTTagList nbttaglist = ntbwriteread.getTagList("Items", 10);
        this.sampleItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < this.sampleItemStacks.length; ++i)
        {
            if (this.sampleItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.sampleItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        this.burnTime = ntbwriteread.getShort("BurnTime");
        this.cookTime = ntbwriteread.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.sampleItemStacks[1]);

        if (ntbwriteread.hasKey("CustomName", 8))
        {
            this.field_145958_o = ntbwriteread.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound ntbwrite)
    {
        super.writeToNBT(ntbwrite);
        ntbwrite.setShort("BurnTime", (short)this.burnTime);
        ntbwrite.setShort("CookTime", (short)this.cookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.sampleItemStacks.length; ++i)
        {
            if (this.sampleItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.sampleItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        ntbwrite.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            ntbwrite.setString("CustomName", this.field_145958_o);
        }
    }

    //かまどの処理
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1)
    {
        return this.cookTime * par1 / 200;
    }

    //かまどの処理
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.burnTime * par1 / this.currentItemBurnTime;
    }

    //かまどの処理
    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    //更新時に呼び出される
    //かまどの処理
    public void updateEntity()
    {
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;

//        this.amountEE = testEE(this.sampleItemStacks[1]);

        if (this.burnTime > 0) {
            --this.burnTime;
            this.generatorAmount += this.amountEE;
        }

        if(burnTime == 0 && this.canSmelt())
        {
            this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.sampleItemStacks[1]);

            if (this.burnTime > 0)
            {
                flag1 = true;

                if (this.sampleItemStacks[1] != null)
                {
                    --this.sampleItemStacks[1].stackSize;

                    if (this.sampleItemStacks[1].stackSize == 0)
                    {
                        this.sampleItemStacks[1] = this.sampleItemStacks[1].getItem().getContainerItem(this.sampleItemStacks[1]);
                    }
                }
            }
        }

        if (this.isBurning() && this.canSmelt())
        {
            ++this.cookTime;

            if (this.cookTime == 200)
            {
                this.cookTime = 0;
                this.smeltItem();
                flag1 = true;
            }
        }
        else
        {
            this.cookTime = 0;
        }

    }

    //かまどの処理
    private boolean canSmelt()
    {
        if (this.sampleItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = AlchemyRecipes.smelting().getSmeltingResult(this.sampleItemStacks[0]);
            if (itemstack == null) return false;
            if (this.sampleItemStacks[2] == null) return true;
            if (!this.sampleItemStacks[2].isItemEqual(itemstack)) return false;
            int result = this.sampleItemStacks[2].stackSize + itemstack.stackSize;
            return (result <= this.getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    //かまどの処理
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = AlchemyRecipes.smelting().getSmeltingResult(this.sampleItemStacks[0]);

            if (this.sampleItemStacks[2] == null)
            {
                this.sampleItemStacks[2] = itemstack.copy();
            }
            else if (this.sampleItemStacks[2].isItemEqual(itemstack))
            {
                this.sampleItemStacks[2].stackSize += itemstack.stackSize;
            }

            --this.sampleItemStacks[0].stackSize;

            if (this.sampleItemStacks[0].stackSize <= 0)
            {
                this.sampleItemStacks[0] = null;
            }
        }
    }

    //かまどの処理
    public static int getItemBurnTime(ItemStack itemStack)
    {
        if (itemStack == null)
        {
            return 0;
        }
        else
        {
            int moddedBurnTime = net.minecraftforge.event.ForgeEventFactory.getFuelBurnTime(itemStack);
            if (moddedBurnTime >= 0) return moddedBurnTime;

            Item item = itemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(itemStack);
        }
    }

    //かまどの処理
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    // スロット数
    @Override
    public int getSizeInventory() {
        return this.sampleItemStacks.length;
    }

    // インベントリ内の任意のスロットにあるアイテムを取得
    @Override
    public ItemStack getStackInSlot(int par1) {
        return this.sampleItemStacks[par1];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {
        if (this.sampleItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.sampleItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.sampleItemStacks[par1];
                this.sampleItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.sampleItemStacks[par1].splitStack(par2);

                if (this.sampleItemStacks[par1].stackSize == 0)
                {
                    this.sampleItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int par1) {
        if (this.sampleItemStacks[par1] != null)
        {
            ItemStack itemstack = this.sampleItemStacks[par1];
            this.sampleItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    // インベントリ内のスロットにアイテムを入れる
    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        this.sampleItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }


    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }



    // インベントリ内のスタック限界値
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }


    // par1EntityPlayerがTileEntityを使えるかどうか
    @Override
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
        return false;
    }


    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
        return false;
    }

    //ホッパーにアイテムの受け渡しをする際の優先度
    @Override
    public int[] getAccessibleSlotsFromSide(int par1) {
        return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
    }

    //ホッパーからアイテムを入れられるかどうか
    @Override
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3) {
        return false;
    }
    //隣接するホッパーにアイテムを送れるかどうか
    @Override
    public boolean canExtractItem(int par2, ItemStack itemStack, int par3) {
        return false;
    }


}