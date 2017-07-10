package violetcraft.items;

import net.minecraft.item.Item;
import violetcraft.VioletCraftRegistry;

public class VirenIngot extends Item
{
    public VirenIngot()
    {
		String name = "vireningot";

		this.setCreativeTab(VioletCraftRegistry.VioletCraftMod);
		this.setUnlocalizedName(name);
	    maxStackSize = 64;
	    this.setTextureName( "violetcraft:VirenIngot" );
    }
}
