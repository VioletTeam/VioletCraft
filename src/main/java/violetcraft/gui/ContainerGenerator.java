package violetcraft.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import violetcraft.tile.TileGenerator;

public class ContainerGenerator extends Container
{
	private TileGenerator tileGenerator;

    public ContainerGenerator(EntityPlayer player, TileGenerator tileEntity) {
        this.tileGenerator = tileEntity;

		// InventorySampleで追加するインベントリ
    	// かまど上部スロット
        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
        // かまど下部スロット
        this.addSlotToContainer(new Slot(tileEntity, 1, 56, 53));


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
            ItemStack itemStack1 = slot.getStack();
            itemstack = itemStack1.copy();

			//スロット番号が2の時
			if (slotNumber == 1)
			{
				//アイテムの移動(スロット3～39へ)
                if (!this.mergeItemStack(itemStack1, 3, 39, true)) {
                    return null;
				}

                slot.onSlotChange(itemStack1, itemstack);
            }
            //スロット番号が0、1でない時
			else if (slotNumber != 1 && slotNumber != 0)
			{
                if (FurnaceRecipes.smelting().getSmeltingResult(itemStack1) != null) {
                    //アイテムの移動(スロット0～1へ)
                    if (!this.mergeItemStack(itemStack1, 0, 1, false)) {
                        return null;
					}
                } else if (!this.mergeItemStack(itemStack1, 29, 38, false)) {
                    //アイテムの移動(スロット1～2へ)
                    if (!this.mergeItemStack(itemStack1, 1, 2, false)) {
                        return null;
					}
				} else if (slotNumber >= 3 && slotNumber < 30) {
					//アイテムの移動(スロット30～39へ)
                    if (!this.mergeItemStack(itemStack1, 30, 39, false)) {
                        return null;
					}
                } else if (slotNumber >= 30 && slotNumber < 39 && !this.mergeItemStack(itemStack1, 3, 30, false)) {
                    return null;
				}
			}
			//アイテムの移動(スロット3～39へ)
            else if (!this.mergeItemStack(itemStack1, 3, 39, false)) {
                return null;
			}
            if (itemStack1.stackSize == 0) {
                slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
            if (itemStack1.stackSize == itemstack.stackSize) {
                return null;
			}
            slot.onPickupFromSlot(entityPlayer, itemStack1);
        }
        return itemstack;
	}
}
