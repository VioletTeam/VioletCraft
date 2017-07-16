package violetcraft.item;

import net.minecraft.item.Item;
import violetcraft.VioletCraftMod;

public class ItemVirenIngot extends Item
{
    public ItemVirenIngot() {
        this.setCreativeTab(VioletCraftMod.tabVioletCraft);
        this.setUnlocalizedName("vc.virenIngot");
        maxStackSize = 64;
        this.setTextureName("violetcraft:viren_ingot");
    }
}
