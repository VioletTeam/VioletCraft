package violetcraft.item.book;

import net.minecraft.item.Item;
import violetcraft.VioletCraftMod;


public class ItemVioletBook extends Item {
    public ItemVioletBook() {
        String name = "violet_book";

        setCreativeTab(VioletCraftMod.tabVioletCraft);
        this.setUnlocalizedName(name);
        maxStackSize = 16;
        this.setTextureName("violetcraft:violet_book");
    }
}
