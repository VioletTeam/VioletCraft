package violetcraft.item.caps;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.wands.WandCap;

import java.util.List;


public class VioletWandCap extends WandCap {
    public VioletWandCap(String tag, float discount, ItemStack item, int craftCost, ResourceLocation skin) {
        super(tag, discount, item, craftCost);
        setTexture(skin);
    }

    public VioletWandCap(String tag, float discount, List<Aspect> specialAspects, float discountSpecial, ItemStack item, int craftCost, ResourceLocation skin) {
        super(tag, discount, specialAspects, discountSpecial, item, craftCost);
        setTexture(skin);
    }
}