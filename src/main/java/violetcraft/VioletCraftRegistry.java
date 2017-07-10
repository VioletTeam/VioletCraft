package violetcraft;

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
import violetcraft.block.BlockVirenBlock;
import violetcraft.block.BlockVirenOre;
import violetcraft.block.machine.BlockGenerator;
import violetcraft.block.ore.BlockBlueTopazOre;
import violetcraft.block.ore.BlockPinkSapphireOre;
import violetcraft.block.ore.BlockRollYellowOre;
import violetcraft.block.ore.BlockScarRedOre;
import violetcraft.item.*;
import violetcraft.item.armor.ItemYukariParker;
import violetcraft.tiles.TileGenerator;
import violetcraft.tiles.TileGuiBlock;

/**
 * @author C6H2Cl2
 */
public final class VioletCraftRegistry {

    /***
     * Material
     */
    public static final ItemArmor.ArmorMaterial Parker = EnumHelper.addArmorMaterial("YUKARIParker", 8, new int[]{3, 5, 6, 3}, 30);
    // Ingot ===========================================================================================================
    public static final Item VirenIngot = new ItemVirenIngot();
    /***
     * クリエイティブタブ
     */
    public static final CreativeTabs tabVioletCraft = new CreativeTabs("violet_craft") {
        public Item getTabIconItem() {
            return VirenIngot;
        }
    };
    public static final Item RollYellowIngot = null;
    public static final Item ScarRedIngot = null;
    public static final Item BLueTopaz = null;
    public static final Item PinkSapphire = null;
    // Tools ===========================================================================================================
    public static final Item VirenSword = new ItemVirenSword();
    // Armor ===========================================================================================================
    public static final Item YukariParker = new ItemYukariParker(Parker, 0, 1);
    // Egg =============================================================================================================
    public static final Item RabbitEgg = new ItemRabbitEgg();
    //Block ============================================================================================================
    public static final Block VirenBlock = new BlockVirenBlock();
    public static final Block Generator = new BlockGenerator();
    // Ore =============================================================================================================
    public static final Block RollYellowOre = new BlockRollYellowOre();
    public static final Block ScarRedOre = new BlockScarRedOre();
    public static final Block BlueTopazOre = new BlockBlueTopazOre();
    public static final Block PinkSapphireOre = new BlockPinkSapphireOre();
    public static final Block VirenOre = new BlockVirenOre();
    // Item ============================================================================================================
    public static Item CookedMoonMeat = new ItemCookedMoonRabbit(5, 6, true);
    public static Item RawMoonMeat = new ItemRawMoonRabbit(3, 1, true);

    static void handlePreInit(FMLPreInitializationEvent event) {
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

        //Register Blocks
        registerBlock(VirenBlock);
        registerBlock(Generator);
        //Register Ores
        registerBlock(VirenOre);
        registerBlock(ScarRedOre);
        registerBlock(PinkSapphireOre);
        registerBlock(BlueTopazOre);
        registerBlock(RollYellowOre);
    }

    static void handleInit(FMLInitializationEvent event) {
        //Register TileEntities
        GameRegistry.registerTileEntity(TileGuiBlock.class, "TileGuiBlock");
        GameRegistry.registerTileEntity(TileGenerator.class, "TileGenerator");

        //Add Recipes
        GameRegistry.addRecipe(new ItemStack(VioletCraftRegistry.VirenSword, 1), " x ", " x ", " y ", 'x', VioletCraftRegistry.VirenIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(VioletCraftRegistry.YukariParker),
                "wbw", "blb", "wpw",
                'b', new ItemStack(Items.dye, 1, 0), 'p', new ItemStack(Items.dye, 1, 9), 'l', Items.leather_chestplate, 'w', Blocks.wool);

        //Add Smelting Recipes
        GameRegistry.addSmelting(VioletCraftRegistry.VirenOre, new ItemStack(VioletCraftRegistry.VirenIngot), 0.1f);

        GameRegistry.registerFuelHandler(fuel -> {
            Item item = fuel.getItem();
            if (item == Items.apple) {
                return 200;
            } else {
                return 0;
            }
        });
    }

    private static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }

    private static void registerItem(Item item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}
