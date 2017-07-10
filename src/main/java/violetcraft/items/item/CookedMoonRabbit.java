package violetcraft.items.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;

import static violetcraft.VioletCraftMod.VioletCradtMod;

public class CookedMoonRabbit extends ItemFood {
    public CookedMoonRabbit(int hanger, float hiddenhanger, boolean wolffood) {
        super(hanger, hiddenhanger, wolffood);
        String name = "cooked_moonrabbit";

        this.setCreativeTab(VioletCradtMod);
        this.setUnlocalizedName(name);
        maxStackSize = 64;
        this.setTextureName("violetcraft:rabbit_cooked");

        GameRegistry.registerItem(this, name);

    }
}
