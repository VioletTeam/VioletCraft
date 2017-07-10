package violetcraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import violetcraft.tiles.TileEntityGenerator;

public class ContainerGenerator extends Container
{
	private TileEntityGenerator tileEntityGenerator;

	public ContainerGenerator(EntityPlayer player, TileEntityGenerator tileentity) {
    	this.tileEntityGenerator = tileentity;

		// InventorySampleで追加するインベントリ
    	// かまど上部スロット
		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		// かまど下部スロット
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));


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

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

	// Shiftクリック
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotNumber)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slotNumber);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			//スロット番号が2の時
			if (slotNumber == 1)
			{
				//アイテムの移動(スロット3～39へ)
				if (!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			//スロット番号が0、1でない時
			else if (slotNumber != 1 && slotNumber != 0)
			{
				if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
				{
					//アイテムの移動(スロット0～1へ)
					if (!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				} else if (!this.mergeItemStack(itemstack1, 29, 38, false)) {
					//アイテムの移動(スロット1～2へ)
					if (!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				} else if (slotNumber >= 3 && slotNumber < 30) {
					//アイテムの移動(スロット30～39へ)
					if (!this.mergeItemStack(itemstack1, 30, 39, false))
					{
						return null;
					}
				}
				else if (slotNumber >= 30 && slotNumber < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
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
			slot.onPickupFromSlot(entityPlayer, itemstack1);
		}
		return itemstack;
	}
}