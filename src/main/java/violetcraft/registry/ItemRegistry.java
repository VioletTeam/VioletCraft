package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.block.BlockVirenBlock;
import violetcraft.block.BlockVirenOre;
import violetcraft.block.VioletBush;
import violetcraft.block.dimension.BlockVioletDift;
import violetcraft.block.dimension.BlockVioletGrass;
import violetcraft.block.dimension.BlockVioletLeave;
import violetcraft.block.dimension.BlockVioletOakLog;
import violetcraft.block.dimension.BlockVioletPortal;
import violetcraft.block.dimension.BlockVioletSapling;
import violetcraft.block.machine.BlockGenerator;
import violetcraft.block.ore.BlockBlueTopazOre;
import violetcraft.block.ore.BlockPinkSapphireOre;
import violetcraft.block.ore.BlockRollYellowOre;
import violetcraft.block.ore.BlockScarRedOre;
import violetcraft.item.ItemCookedMoonRabbit;
import violetcraft.item.ItemMoonRabbitTear;
import violetcraft.item.ItemRabbitEgg;
import violetcraft.item.ItemRawMoonRabbit;
import violetcraft.item.ItemVirenIngot;
import violetcraft.item.ItemVirenScythe;
import violetcraft.item.ItemVirenSword;
import violetcraft.item.armor.ItemYukariParker;

public class ItemRegistry{
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
    //Block ============================================================================================================
    public static final Block VirenBlock = new BlockVirenBlock();
    public static final Block Generator = new BlockGenerator();
    public static final Block VioletGrassBlock = new BlockVioletGrass();
    public static final Block VioletGrass = new VioletBush();
    public static final Block VioletDift = new BlockVioletDift();
    public static final Block VioletPortal = new BlockVioletPortal();
    public static final Block VioletSapling = new BlockVioletSapling();
    public static final Block VioletLeave = new BlockVioletLeave();
    public static final Block VioletOakLog = new BlockVioletOakLog();
    // Ore =============================================================================================================
    public static final Block RollYellowOre = new BlockRollYellowOre();
    public static final Block ScarRedOre = new BlockScarRedOre();
    public static final Block BlueTopazOre = new BlockBlueTopazOre();
    public static final Block PinkSapphireOre = new BlockPinkSapphireOre();
    public static final Block VirenOre = new BlockVirenOre();

    public static void addItemRegistry() {
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
}
