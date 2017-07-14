package violetcraft.item;


import net.minecraft.item.ItemFood;
import violetcraft.VioletCraftRegistry;

public class ItemCookedMoonRabbit extends ItemFood {
    public ItemCookedMoonRabbit(int hanger, float hiddenhanger, boolean wolffood) {
        super(hanger, hiddenhanger, wolffood);
        String name = "cooked_moonrabbit";

        setCreativeTab(VioletCraftRegistry.tabVioletCraft);
        this.setUnlocalizedName(name);
        maxStackSize = 64;
        this.setTextureName("violetcraft:rabbit_cooked");
    }
}
