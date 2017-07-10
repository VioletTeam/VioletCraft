package violetcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import violetcraft.VioletCraftMod;

public class ItemVirenIngot extends Item
{
    public ItemVirenIngot()
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
