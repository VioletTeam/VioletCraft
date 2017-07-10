package violetcraft.tiles;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import violetcraft.item.ItemTestMachine;

public class TilEntityeTestMachine extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};

    public int furnaceBurnTime;
    public int currentItemBurnTime;
    public int furnaceCookTime;

    private String field_145958_o;

	private ItemStack[] testMachineItemStacks = new ItemStack[3];

	@Override
	public int getSizeInventory() {
		return this.testMachineItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return this.testMachineItemStacks[p_70301_1_];
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
//		return null;
        if (this.testMachineItemStacks[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.testMachineItemStacks[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.testMachineItemStacks[p_70298_1_];
                this.testMachineItemStacks[p_70298_1_] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.testMachineItemStacks[p_70298_1_].splitStack(p_70298_2_);

                if (this.testMachineItemStacks[p_70298_1_].stackSize == 0)
                {
                    this.testMachineItemStacks[p_70298_1_] = null;
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
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        if (this.testMachineItemStacks[p_70304_1_] != null)
        {
            ItemStack itemstack = this.testMachineItemStacks[p_70304_1_];
            this.testMachineItemStacks[p_70304_1_] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

    /**
     * スロットコンテナ
     */
	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
        this.testMachineItemStacks[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.field_145958_o : "container.testMachine";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.field_145958_o != null && this.field_145958_o.length() > 0;
	}

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.testMachineItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.testMachineItemStacks.length)
            {
                this.testMachineItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = p_145839_1_.getShort("BurnTime");
        this.furnaceCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.testMachineItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.field_145958_o = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.furnaceBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.testMachineItemStacks.length; ++i)
        {
            if (this.testMachineItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.testMachineItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.field_145958_o);
        }
    }

    public static int getItemBurnTime(ItemStack itemStack) {
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

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(p_145954_0_) > 0;
    }

	@Override
	public int getInventoryStackLimit() {
        return 64;
	}

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_)
    {
        return this.furnaceCookTime * p_145953_1_ / 200;

    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.furnaceBurnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (this.furnaceBurnTime > 0)
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime != 0 || this.testMachineItemStacks[1] != null && this.testMachineItemStacks[0] != null)
            {
                if (this.furnaceBurnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.testMachineItemStacks[1]);

                    if (this.furnaceBurnTime > 0)
                    {
                        flag1 = true;

                        if (this.testMachineItemStacks[1] != null)
                        {
                        	//下段のアテイム　燃焼始めたとき消費する
                            --this.testMachineItemStacks[1].stackSize;

                            if (this.testMachineItemStacks[1].stackSize == 0)
                            {
                                this.testMachineItemStacks[1] = testMachineItemStacks[1].getItem().getContainerItem(testMachineItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.furnaceCookTime;

                    if (this.furnaceCookTime == 200)
                    {
                        this.furnaceCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.furnaceCookTime = 0;
                }
            }

            if (flag != this.furnaceBurnTime > 0)
            {
                flag1 = true;
                //block見た目更新
                ItemTestMachine.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    //錬金術出来る
    private boolean canSmelt()
    {
        if (this.testMachineItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.testMachineItemStacks[0]);
            if (itemstack == null) return false;
            if (this.testMachineItemStacks[2] == null) return true;
            if (!this.testMachineItemStacks[2].isItemEqual(itemstack)) return false;
            int result = testMachineItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.testMachineItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    //錬金アイテム
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(this.testMachineItemStacks[0]);

            if (this.testMachineItemStacks[2] == null)
            {
                this.testMachineItemStacks[2] = itemstack.copy();
            }
            else if (this.testMachineItemStacks[2].getItem() == itemstack.getItem())
            {
                this.testMachineItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            //上段のアイテム　錬成した後減らす
            --this.testMachineItemStacks[0].stackSize;

            if (this.testMachineItemStacks[0].stackSize <= 0)
            {
                this.testMachineItemStacks[0] = null;
            }
        }
    }


	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;

	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return p_94041_1_ == 2 ? false : (p_94041_1_ == 1 ? isItemFuel(p_94041_2_) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return p_94128_1_ == 0 ? slotsBottom : (p_94128_1_ == 1 ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Items.bucket;
	}

}
