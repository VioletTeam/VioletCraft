package violetcraft.items.armor;


import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import violetcraft.VioletCraftRegistry;

public class ItemYukariParker extends ItemArmor {
    public ItemYukariParker(ItemArmor.ArmorMaterial Parker, int p_i45325_2_, int p_i45325_3_) {
        super(Parker, p_i45325_2_, p_i45325_3_);
        this.setCreativeTab(VioletCraftRegistry.VioletCraftMod);
        this.setUnlocalizedName("vc.yukari_parker");
        maxStackSize = 1;
        this.setTextureName("violetcraft:yukari_parker");
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "violetcraft:textures/armor/yukari_layer_1.png";
    }
}