package violetcraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.VioletCraftMod;

public class ItemVirenScythe extends ItemSword {

	public String name = "viren_scythe";

	public static ToolMaterial ToolMaterial;
    public static Item toolconf;

	/* 定数名 */
	public static final String toolMaterialName = "VIRENBLOCK";
	/* 採掘レベル */
	public static final int miningLevel = 3;
	/* 使用回数（耐久値）*/
	public static final int endurance = 700;
	/* 採掘速度 */
	public static final float speed = 8F;
	/*エンティティに対するダメージ*/
	public static final float damage = 10F;
	/*エンチャント補正*/
	public static final int correction = 10;


	public ItemVirenScythe (ToolMaterial ToolMaterial) {
		super(ToolMaterial);
		ToolMaterial = EnumHelper.addToolMaterial("VIRENBLOCK", miningLevel, endurance, speed, damage, correction);

		setUnlocalizedName(name);
		setCreativeTab(VioletCraftMod.VioletCradtTab);
		setTextureName( "violetcraft:" + name );

	    maxStackSize = 1;
	}

	/**
	 * アイテムをマウスオーバーした際の情報表示
	 */
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
    {
        list.add("手にしたものは特別な力が宿ると言われている。");
    }
}
