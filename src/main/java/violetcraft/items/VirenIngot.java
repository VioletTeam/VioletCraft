package violetcraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import violetcraft.VioletCraftMod;

public class VirenIngot extends Item
{
    public VirenIngot()
    {
		String name = "vireningot";

		this.setCreativeTab( VioletCraftMod.VioletCradtMod );
	    this.setUnlocalizedName(name);
	    maxStackSize = 64;
	    this.setTextureName( "violetcraft:VirenIngot" );

	    GameRegistry.registerItem(this,name);

	    return;
    }
}
