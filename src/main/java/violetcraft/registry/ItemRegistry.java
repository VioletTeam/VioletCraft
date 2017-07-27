package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import thaumcraft.api.wands.WandCap;
import violetcraft.item.*;
import violetcraft.item.armor.ItemYukariParker;
import violetcraft.item.book.ItemVioletBook;
import violetcraft.item.caps.ItemWandCaps;
import violetcraft.item.caps.VioletWandCap;

public class ItemRegistry{
    public static final Item Magicpaper = ItemIntermediate.createItem("magicpaper", "magicpaper");
    public static final Item violetbook =new ItemVioletBook();
    public static final Item MyPiece = ItemIntermediate.createItem("my_piece", "my_piece");
    public static final Item MyCore = ItemIntermediate.createItem("my_core", "my_core");
    public static final Item tear_eye =ItemIntermediate.createItem("tear_eye", "tear_eye");
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
    //cap
    public static WandCap violetcaps;
    public static Item wandCap;
    public static void addItemRegistry() {
        GameRegistry.registerItem(MyPiece, "my_piece");
        GameRegistry.registerItem(Magicpaper, "magicpaper");
        GameRegistry.registerItem(MyCore, "my_core");
        GameRegistry.registerItem(tear_eye,"tear_eye");
        registerItem(violetbook);
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
    public static void addcap(){
        wandCap = new ItemWandCaps().setUnlocalizedName("WandCaps");
        violetcaps = new VioletWandCap("viren", 0.8F, new ItemStack(wandCap, 1, 2), 1, new ResourceLocation("violetcraft", "textures/models/wand_cap_viren.png"));
    }

    private static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}
