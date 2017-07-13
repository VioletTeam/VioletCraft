package violetcraft.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import violetcraft.VioletCraftMod;

public class MoonRabbitTear extends Item {
    public MoonRabbitTear() {
        String name = "moonrabbit_tear";

        this.setCreativeTab(VioletCraftMod.VioletCradtTab);
        this.setUnlocalizedName(name);
        maxStackSize = 16;
        this.setTextureName("violetcraft:moonrabbit_tear");


    }
}
