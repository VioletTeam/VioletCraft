package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.VioletCraftMod;
import violetcraft.item.ItemCookedMoonRabbit;
import violetcraft.item.ItemMoonRabbitTear;
import violetcraft.item.ItemRabbitEgg;
import violetcraft.item.ItemRawMoonRabbit;
import violetcraft.item.ItemVirenIngot;
import violetcraft.item.ItemVirenScythe;
import violetcraft.item.ItemVirenSword;
import violetcraft.item.armor.ItemYukariParker;

public class ItemRegistry{
	public static final Item Item = new Item();
    //Material =========================================================================================================
    public static final ItemArmor.ArmorMaterial Parker = EnumHelper.addArmorMaterial("YUKARIParker", 8, new int[]{3, 5, 6, 3}, 30);
    public static final Item RollYellowIngot = null;
    public static final Item ScarRedIngot = null;
    public static final Item BLueTopaz = null;
    public static final Item PinkSapphire = null;
    // Item ============================================================================================================
    public static final Item CookedMoonMeat = new ItemCookedMoonRabbit(5, 6, true);
    public static final Item RawMoonMeat = new ItemRawMoonRabbit(3, 1, true);
    // Ingot ===========================================================================================================
    public static final Item VirenIngot = new ItemVirenIngot();
    // Tools ===========================================================================================================
    public static final Item VirenSword = new ItemVirenSword();
    public static final Item ItemVirenScythe = new ItemVirenScythe("viren_scythe", VioletCraftMaterialRegistry.VIRENBLOCK);
    // Armor ===========================================================================================================
    public static final Item YukariParker = new ItemYukariParker(Parker, 0, 1);
    // Egg =============================================================================================================
    public static final Item RabbitEgg = new ItemRabbitEgg();
    // Tear =============================================================================================================
    public static final Item RabbitTear = new ItemMoonRabbitTear();

    public static void addItemRegistry() {
    	IntermediateItem(Item, "my_piece");
        //Register Items
        registerItem(RawMoonMeat);
        registerItem(CookedMoonMeat);
        //Register Ingots
        registerItem(VirenIngot);
        //Register Tools
        registerItem(VirenSword);
        registerItem(ItemVirenScythe);
        //Register Armors
        registerItem(YukariParker);
        //Register Eggs
        registerItem(RabbitEgg);
        //Register Tear
        registerItem(RabbitTear);
    }

    private static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }

    /**
     * 中間アイテムなどの素材用のアイテムの追加
     *
     * @param item Item
     * @param name アイテム名
     */
    public static void IntermediateItem(Item item, String name) {
    	item.setCreativeTab(VioletCraftMod.tabVioletCraft);
    	item.setUnlocalizedName(name);
    	item.setTextureName("violetcraft:" + name);
    	item.setMaxStackSize(64);
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}
