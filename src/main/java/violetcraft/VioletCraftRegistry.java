package violetcraft;

import cpw.mods.fml.common.IFuelHandler;
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
import violetcraft.block.BlockGenerator;
import violetcraft.block.BlockVirenBlock;
import violetcraft.block.BlockVirenOre;
import violetcraft.items.Rabbitegg;
import violetcraft.items.VirenIngot;
import violetcraft.items.VirenSword;
import violetcraft.items.armor.YukariParker;
import violetcraft.items.block.ore.BlueTopazOre;
import violetcraft.items.block.ore.PinkSapphireOre;
import violetcraft.items.block.ore.RollYellowOre;
import violetcraft.items.block.ore.ScarRedOre;
import violetcraft.items.machine.TestMachine;
import violetcraft.tiles.TilEntityeTestMachine;
import violetcraft.tiles.TileEntityGenerator;
import violetcraft.tiles.TileEntityGuiBlock;

/**
 * @author C6H2Cl2
 */
public final class VioletCraftRegistry {
    /***
     * Material
     */
    public static final ItemArmor.ArmorMaterial Parker = EnumHelper.addArmorMaterial("YUKARIParker", 8, new int[]{3, 5, 6, 3}, 30);
    // Item ============================================================================================================
    // Ingot ===========================================================================================================
    public static final Item VirenIngot = new VirenIngot();
    /***
     * クリエイティブタブ
     */
    public static final CreativeTabs VioletCraftMod = new CreativeTabs("violet_craft") {
        public Item getTabIconItem() {
            return VirenIngot;
        }
    };
    public static final Item RollYellowIngot = null;
    public static final Item ScarRedIngot = null;
    public static final Item blueTopaz = null;
    public static final Item PinkSapphire = null;

    // Tools ===========================================================================================================
    public static final Item VirenSword = new VirenSword();

    // Armor ===========================================================================================================
    public static final Item yukariParker = new YukariParker(Parker, 0, 1);

    // Egg =============================================================================================================
    public static final Item rabbitegg = new Rabbitegg();

    //Block ============================================================================================================
    public static final Block BlockVirenBlock = new BlockVirenBlock("viren_block");
    public static final Block TestMachine = new TestMachine();
    public static final Block BlockGenerator = new BlockGenerator();

    // Ore =============================================================================================================
    public static final Block RollYellowOre = new RollYellowOre();
    public static final Block ScarRedOre = new ScarRedOre();
    public static final Block blueTopazOre = new BlueTopazOre();
    public static final Block PinkSapphireOre = new PinkSapphireOre();
    public static final Block BlockVirenOre = new BlockVirenOre();

    static void handlePreInit(FMLPreInitializationEvent event) {
        //Register Items
        //Register Ingots
        registerItem(VirenIngot);
        //Register Tools
        registerItem(VirenSword);
        //Register Armors
        registerItem(yukariParker);
        //Register Eggs
        registerItem(rabbitegg);

        //Register Blocks
        registerBlock(BlockVirenBlock);
        registerBlock(TestMachine);
        registerBlock(BlockGenerator);
        //Register Ores
        registerBlock(BlockVirenOre);
        registerBlock(ScarRedOre);
        registerBlock(PinkSapphireOre);
        registerBlock(blueTopazOre);
        registerBlock(RollYellowOre);
    }

    static void handleInit(FMLInitializationEvent event) {
        //Register TileEntities
        GameRegistry.registerTileEntity(TileEntityGuiBlock.class, "TileEntityGuiBlock");
        GameRegistry.registerTileEntity(TilEntityeTestMachine.class, "TilEntityeTestMachine");
        GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");

        //Add Recipes
        GameRegistry.addRecipe(new ItemStack(VioletCraftRegistry.VirenSword, 1), " x ", " x ", " y ", 'x', VioletCraftRegistry.VirenIngot, 'y', Items.stick);
        GameRegistry.addRecipe(new ItemStack(VioletCraftRegistry.yukariParker),
                "wbw", "blb", "wpw",
                'b', new ItemStack(Items.dye, 1, 0), 'p', new ItemStack(Items.dye, 1, 9), 'l', Items.leather_chestplate, 'w', Blocks.wool);

        //Add Smelting Recipes
        GameRegistry.addSmelting(VioletCraftRegistry.BlockVirenOre, new ItemStack(VioletCraftRegistry.VirenIngot), 0.1f);

        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel) {
                Item item = fuel.getItem();
                if (item == Items.apple) {
                    return 200;
                } else {
                    return 0;
                }
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
