package violetcraft.items;

import net.minecraft.item.Item;
import violetcraft.VioletCraftRegistry;

public class ItemVirenIngot extends Item
{
	public ItemVirenIngot() {
		this.setCreativeTab(VioletCraftRegistry.VioletCraftMod);
		this.setUnlocalizedName("vc.virenIngot");
		maxStackSize = 64;
		this.setTextureName("violetcraft:item_viren_ingot");
	}
}