package violetcraft.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import violetcraft.tiles.TilEntityeTestMachine;

public class ContainerTestMachine extends Container
{
	private TilEntityeTestMachine tileentity;

	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

    public ContainerTestMachine(EntityPlayer player, TilEntityeTestMachine tileEntity)
    {
//    	this.addSlotToContainer(new Slot(new TilEntityeTestMachine(), 1, 1, 1 ));

    	this.tileentity = tileEntity;

		// InventorySampleで追加するインベントリ
    	// かまど上部スロット
		this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
		// かまど下部スロット
		this.addSlotToContainer(new Slot(tileEntity, 1, 56, 53));
		// かまど完成スロット
		this.addSlotToContainer(new SlotFurnace(player, tileEntity, 2, 116, 35));

		int i;
		// プレイヤーインベントリ　1 ～ 3段目
		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// プレイヤーインベントリ　4段目
		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
    }

    public void addCraftingToCrafters(ICrafting p_75132_1_)
    {
        super.addCraftingToCrafters(p_75132_1_);
        p_75132_1_.sendProgressBarUpdate(this, 0, this.tileentity.furnaceCookTime);
        p_75132_1_.sendProgressBarUpdate(this, 1, this.tileentity.furnaceBurnTime);
        p_75132_1_.sendProgressBarUpdate(this, 2, this.tileentity.currentItemBurnTime);
    }

	// 更新を送る
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting)this.crafters.get(i);

			if (this.lastCookTime != this.tileentity.furnaceCookTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.tileentity.furnaceCookTime);
			}

			if (this.lastBurnTime != this.tileentity.furnaceBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.tileentity.furnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.tileentity.currentItemBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 2, this.tileentity.currentItemBurnTime);
			}
		}

		this.lastCookTime = this.tileentity.furnaceCookTime;
		this.lastBurnTime = this.tileentity.furnaceBurnTime;
		this.lastItemBurnTime = this.tileentity.currentItemBurnTime;
	}


	// 更新する
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2)
	{
		if (par1 == 0)
		{
			this.tileentity.furnaceCookTime = par2;
		}

		if (par1 == 1)
		{
			this.tileentity.furnaceBurnTime = par2;
		}

		if (par1 == 2)
		{
			this.tileentity.currentItemBurnTime = par2;
		}
	}


    @Override
    public boolean canInteractWith(EntityPlayer player) {
//    	return tileentity.isUseableByPlayer(player);
        return true;
    }

	// Shiftクリック
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			//スロット番号が2の時
			if (par2 == 2)
			{
				//アイテムの移動(スロット3～39へ)
				if (!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			//スロット番号が0、1でない時
			else if (par2 != 1 && par2 != 0)
			{
				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
				{
					//アイテムの移動(スロット0～1へ)
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
				else if (TileEntityFurnace.isItemFuel(itemstack1))
				{
					//アイテムの移動(スロット1～2へ)
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				}
				else if (par2 >= 3 && par2 < 30)
				{
					//アイテムの移動(スロット30～39へ)
					if (!this.mergeItemStack(itemstack1, 30, 39, false))
					{
						return null;
					}
				}
				else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			}
			//アイテムの移動(スロット3～39へ)
			else if (!this.mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}
			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}
		return itemstack;
	}
}
