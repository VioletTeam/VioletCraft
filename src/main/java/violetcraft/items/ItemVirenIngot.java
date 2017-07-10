package violetcraft.items;

import net.minecraft.item.Item;
import violetcraft.VioletCraftRegistry;

public class ItemVirenIngot extends Item
{
	public ItemVirenIngot() {
		String name = "vireningot";

		this.setCreativeTab(VioletCraftRegistry.VioletCraftMod);
		this.setUnlocalizedName(name);
	    maxStackSize = 64;
		this.setTextureName("violetcraft:ItemVirenIngot");
	}
}
