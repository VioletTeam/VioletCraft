package violetcraft.registry;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class VioletCraftMaterialRegistry {
	/**
	 * EnumHelper.addToolMaterial(定数名, 採掘レベル, 使用回数（耐久値）, 採掘速度, エンティティに対するダメージ, エンチャント補正)
	 */
	public static ToolMaterial VIRENBLOCK = EnumHelper.addToolMaterial("VIRENBLOCK", 3, 700, 8F, 10F, 10);

}
