package violetcraft.item;

import net.minecraft.item.Item;
import violetcraft.VioletCraftMod;

public class ItemIntermediate {

    /**
     * 中間アイテムなどの素材用のアイテムの追加
     *
     * @param name アイテム名
     * @param textureName テクスチャ名
     */
    public static Item createItem(String name, String textureName) {
    	Item item = new Item();
    	item.setCreativeTab(VioletCraftMod.tabVioletCraft);
    	item.setUnlocalizedName(name);
    	item.setTextureName("violetcraft:" + textureName);
    	item.setMaxStackSize(64);

        return item;
    }
}
