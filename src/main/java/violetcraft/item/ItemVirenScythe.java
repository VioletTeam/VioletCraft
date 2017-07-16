package violetcraft.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import violetcraft.VioletCraftMod;

public class ItemVirenScythe extends ItemSword {

	/**
	 *　ヴァイレンサイス
	 *
	 * @param name アイテム名
	 * @param VIRENBLOCK 材質
	 */
	public ItemVirenScythe (String name, ToolMaterial VIRENBLOCK) {
		super(VIRENBLOCK);

		setUnlocalizedName(name);
		setCreativeTab(VioletCraftMod.tabVioletCraft);
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
