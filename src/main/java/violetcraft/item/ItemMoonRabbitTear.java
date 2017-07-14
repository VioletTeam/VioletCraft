package violetcraft.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import violetcraft.VioletCraftRegistry;

public class ItemMoonRabbitTear extends Item {
    public ItemMoonRabbitTear() {
        String name = "moonrabbit_tear";

        setCreativeTab(VioletCraftRegistry.tabVioletCraft);
        this.setUnlocalizedName(name);
        maxStackSize = 16;
        this.setTextureName("violetcraft:moonrabbit_tear");

        GameRegistry.registerItem(this, name);

    }
}
