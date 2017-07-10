package violetcraft.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import violetcraft.VioletCraft;

public class ItemRawMoonRabbit extends ItemFood {
    public ItemRawMoonRabbit(int hanger, float hiddenhanger, boolean wolffood) {
        super(hanger, hiddenhanger, wolffood);
        String name = "raw_moonrabbit";

        setCreativeTab(VioletCraft.VioletCradtTab);
        setUnlocalizedName(name);
        maxStackSize = 64;
        this.setTextureName("violetcraft:rabbit_raw");

        GameRegistry.registerItem(this, name);

    }
    protected void onFoodEaten(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_)
    {
        ItemFishFood.FishType fishtype = ItemFishFood.FishType.func_150978_a(p_77849_1_);
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 1));
            p_77849_3_.addPotionEffect(new PotionEffect(Potion.confusion.id, 150, 0));

        super.onFoodEaten(p_77849_1_, p_77849_2_, p_77849_3_);
    }
}
