package violetcraft.item;

import net.minecraft.item.Item;
import violetcraft.VioletCraftRegistry;

public class ItemVirenIngot extends Item
{
    public ItemVirenIngot() {
        this.setCreativeTab(VioletCraftRegistry.tabVioletCraft);
        this.setUnlocalizedName("vc.virenIngot");
        maxStackSize = 64;
        this.setTextureName("violetcraft:viren_ingot");
    }
}
