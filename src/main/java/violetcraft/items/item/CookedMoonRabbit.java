package violetcraft.items.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;

import static violetcraft.VioletCraftMod.VioletCradtMod;

public class CookedMoonRabbit extends ItemFood {
    public CookedMoonRabbit(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
        String name = "cooked_moonrabbit";

        this.setCreativeTab(VioletCradtMod);
        this.setUnlocalizedName(name);
        maxStackSize = 64;
        this.setTextureName("violetcraft:rabbit_cooked");

        GameRegistry.registerItem(this, name);

    }
}
