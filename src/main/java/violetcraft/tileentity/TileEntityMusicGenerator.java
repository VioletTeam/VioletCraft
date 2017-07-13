package violetcraft.tileentity;

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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import violetcraft.api.cofh.api.energy.EnergyStorage;
import violetcraft.api.cofh.api.energy.IEnergyReceiver;
import violetcraft.api.cofh.api.energy.IEnergyStorage;
import violetcraft.api.cofh.api.energy.TileEnergyHandler;

public class TileEntityMusicGenerator extends TileEntity implements ISidedInventory
{
	//生成時間
	public int generatorTime;
	public int currentItemBurnTime;

	//生成量
	public int generatorAmount;
	public int currentgeneratorAmount;
	public int generatorCookTime;
	public int amountEE;
	public IEnergyStorage energyStorage = new EnergyStorage(10000, 10000, 10000);


	private String field_145958_o;

	private ItemStack[] GeneratorItemStack = new ItemStack[3];

    public boolean isBurning()
    {
        return this.generatorTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.generatorTime * p_145955_1_ / this.currentItemBurnTime;
    }

	public void updateEntity()
	{
        boolean flag = this.generatorTime > 0;
        boolean flag1 = false;

        IEnergyReceiver test = new TileEnergyHandler();

        if (this.generatorTime > 0)
        {
            --this.generatorTime;


            energyStorage.receiveEnergy(100, false);
            generatorAmount = energyStorage.getEnergyStored();
//            		this.amountEE;

        }

        if (this.generatorTime != 0 || this.GeneratorItemStack[1] != null)
        {
            if (this.generatorTime == 0)
            {
            	this.currentItemBurnTime = this.generatorTime = getItemBurnTime(this.GeneratorItemStack[1]);
            	this.amountEE = testEE(this.GeneratorItemStack[1]);
        		if (this.generatorTime > 0)
        		{
        			if(this.GeneratorItemStack[1] != null)
        			{
        				//燃料アイテムの1減少
        				--this.GeneratorItemStack[1].stackSize;
        	            if (this.GeneratorItemStack[1].stackSize == 0)
        	            {
        	                this.GeneratorItemStack[1] = GeneratorItemStack[1].getItem().getContainerItem(GeneratorItemStack[1]);
        	            }
        			}
        		}
            }
        }
	}

	public static int testEE(ItemStack itemStack)
	{
		if(itemStack == null)
		{
			return 0;
		} else {
        	int moddedBurnTime = net.minecraftforge.event.ForgeEventFactory.getFuelBurnTime(itemStack);
        	if (moddedBurnTime >= 0) return moddedBurnTime;

			Item item = itemStack.getItem();
            if (item == Items.coal) return 100;
            return GameRegistry.getFuelValue(itemStack);
		}
	}

	//アイテムの燃焼時間
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

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.GeneratorItemStack = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.GeneratorItemStack.length)
            {
                this.GeneratorItemStack[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.generatorTime = p_145839_1_.getShort("BurnTime");
        this.amountEE = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.GeneratorItemStack[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.field_145958_o = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.generatorTime);
        p_145841_1_.setShort("CookTime", (short)this.amountEE);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.GeneratorItemStack.length; ++i)
        {
            if (this.GeneratorItemStack[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.GeneratorItemStack[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.field_145958_o);
        }
    }

	//調理進捗バーの取得
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1)
	{
		return this.generatorTime * par1 / 200;
	}

	//残り時間バー取得
//    @SideOnly(Side.CLIENT)
//    public int getBurnTimeRemainingScaled(int p_145955_1_)
//    {
//        if (this.currentItemBurnTime == 0)
//        {
//            this.currentItemBurnTime = 200;
//        }
//
//        return this.furnaceBurnTime * p_145955_1_ / this.currentItemBurnTime;
//    }

	//更新時に呼び出す。


	@Override
	public int getSizeInventory() {
		return this.GeneratorItemStack.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.GeneratorItemStack[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(this.GeneratorItemStack[slot] != null)
		{
			ItemStack itemstack;
			itemstack = this.GeneratorItemStack[slot];
			this.GeneratorItemStack[slot] = null;
			return itemstack;
		} else {
			return null;
		}

//		if(this.generatorItemStacks[slot] != null)
//		{
//			ItemStack itemstack;
//			if (this.generatorItemStacks[slot].stackSize <= amount)
//			{
//				itemstack = this.generatorItemStacks[slot];
//				this.generatorItemStacks[slot] = null;
//				return itemstack;
//			} else {
//				itemstack = this.generatorItemStacks[slot].splitStack(amount);
//				if(this.generatorItemStacks[slot].stackSize == 0)
//				{
//					this.generatorItemStacks[slot] = null;
//				}
//				return itemstack;
//			}
//		} else {
//			return null;
//		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack itemStack) {
		this.GeneratorItemStack[p_70299_1_] = itemStack;
		if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
		{
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}


}
