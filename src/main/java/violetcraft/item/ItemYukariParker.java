package violetcraft.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import violetcraft.VioletCraftMod;

public class ItemYukariParker extends ItemArmor {
    public ItemYukariParker(ItemArmor.ArmorMaterial Parker, int p_i45325_2_, int p_i45325_3_) {
        super(Parker, p_i45325_2_, p_i45325_3_);
        String name = "yukariparker";

		setCreativeTab(VioletCraftMod.VioletCradtTab);
        this.setUnlocalizedName(name);
        maxStackSize = 1;
        this.setTextureName( "violetcraft:Yukariparker" );

        GameRegistry.registerItem(this,name);

        return;
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "violetcraft:textures/armor/yukari_layer_1.png";
    }
}