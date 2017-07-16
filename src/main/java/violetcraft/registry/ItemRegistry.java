package violetcraft.registry;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.registry.ItemRegistry;
import violetcraft.block.BlockVirenBlock;
import violetcraft.block.BlockVirenOre;
import violetcraft.block.VioletBush;
import violetcraft.block.dimension.*;
import violetcraft.block.machine.BlockGenerator;
import violetcraft.block.ore.BlockBlueTopazOre;
import violetcraft.block.ore.BlockPinkSapphireOre;
import violetcraft.block.ore.BlockRollYellowOre;
import violetcraft.block.ore.BlockScarRedOre;
import violetcraft.item.*;
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
    // Creative Tab ====================================================================================================
    public static final CreativeTabs tabVioletCraft = new CreativeTabs("violet_craft") {
        public Item getTabIconItem() {
            return VirenIngot;
        }
    };
    // Tools ===========================================================================================================
    public static final Item VirenSword = new ItemVirenSword();
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