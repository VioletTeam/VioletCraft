package violetcraft.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;
import violetcraft.VioletCraft;

public class ItemCookedMoonRabbit extends ItemFood {
    public ItemCookedMoonRabbit(int hanger, float hiddenhanger, boolean wolffood) {
        super(hanger, hiddenhanger, wolffood);
        String name = "cooked_moonrabbit";

        setCreativeTab(VioletCraft.VioletCradtTab);
        this.setUnlocalizedName(name);
        maxStackSize = 64;
        this.setTextureName("violetcraft:rabbit_cooked");

        GameRegistry.registerItem(this, name);

    }
}
