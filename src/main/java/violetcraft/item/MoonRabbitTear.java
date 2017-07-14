package violetcraft.item;


import net.minecraft.item.Item;
import violetcraft.VioletCraftRegistry;

public class MoonRabbitTear extends Item {
    public MoonRabbitTear() {
        String name = "moonrabbit_tear";

        this.setCreativeTab(VioletCraftRegistry.tabVioletCraft);
        this.setUnlocalizedName(name);
        maxStackSize = 16;
        this.setTextureName("violetcraft:moonrabbit_tear");


    }
}
