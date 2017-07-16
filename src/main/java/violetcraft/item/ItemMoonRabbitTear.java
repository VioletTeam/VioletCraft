package violetcraft.item;


import net.minecraft.item.Item;
import violetcraft.VioletCraftMod;

public class ItemMoonRabbitTear extends Item {
    public ItemMoonRabbitTear() {
        String name = "moonrabbit_tear";

        setCreativeTab(VioletCraftMod.tabVioletCraft);
        this.setUnlocalizedName(name);
        maxStackSize = 16;
        this.setTextureName("violetcraft:moonrabbit_tear");
    }
}
