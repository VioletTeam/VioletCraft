package violetcraft.items.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

import static violetcraft.VioletCraftMod.VioletCradtMod;

public class MoonRabbitTear extends Item {
    public MoonRabbitTear() {
        String name = "moonrabbit_tear";

        this.setCreativeTab(VioletCradtMod);
        this.setUnlocalizedName(name);
        maxStackSize = 16;
        this.setTextureName("violetcraft:moonrabbit_tear");

        GameRegistry.registerItem(this, name);

    }
}
