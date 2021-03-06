package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import violetcraft.block.BlockVirenBlock;
import violetcraft.block.VioletBush;
import violetcraft.block.dimension.BlockVioletDift;
import violetcraft.block.dimension.BlockVioletGrass;
import violetcraft.block.dimension.BlockVioletLeave;
import violetcraft.block.dimension.BlockVioletOakLog;
import violetcraft.block.dimension.BlockVioletOakPlank;
import violetcraft.block.dimension.BlockVioletPortal;
import violetcraft.block.dimension.BlockVioletSapling;
import violetcraft.block.machine.BlockAlchemy;
import violetcraft.block.machine.BlockGenerator;
import violetcraft.block.ore.BlockBlueTopazOre;
import violetcraft.block.ore.BlockPinkSapphireOre;
import violetcraft.block.ore.BlockRollYellowOre;
import violetcraft.block.ore.BlockScarRedOre;
import violetcraft.block.ore.BlockVirenOre;

public class BlockRegistry {


    //Block ============================================================================================================
    public static final Block VirenBlock = new BlockVirenBlock();
    public static final Block Generator = new BlockGenerator();
    public static final Block AlchemyMachine = new BlockAlchemy();
    public static final Block VioletGrassBlock = new BlockVioletGrass();
    public static final Block VioletGrass = new VioletBush();
    public static final Block VioletDift = new BlockVioletDift();
    public static final Block VioletPortal = new BlockVioletPortal();
    public static final Block VioletSapling = new BlockVioletSapling();
    public static final Block VioletLeave = new BlockVioletLeave();
    public static final Block VioletOakLog = new BlockVioletOakLog();
    public static final Block VioletOakPlank = new BlockVioletOakPlank();

    /* ore */
    public static final Block RollYellowOre = new BlockRollYellowOre();
    public static final Block ScarRedOre = new BlockScarRedOre();
    public static final Block BlueTopazOre = new BlockBlueTopazOre("blue_topaz_ore");
    public static final Block PinkSapphireOre = new BlockPinkSapphireOre("pink_sapphire_ore");
    public static final Block VirenOre = new BlockVirenOre();

	public static void addBlockRegistry() {
        //Register Blocks
        registerBlock(VirenBlock);
        registerBlock(Generator);
        registerBlock(AlchemyMachine);
        registerBlock(VioletGrassBlock);
        registerBlock(VioletGrass);
        registerBlock(VioletDift);
        registerBlock(VioletPortal);
        registerBlock(VioletSapling);
        registerBlock(VioletLeave);
        registerBlock(VioletOakLog);
        registerBlock(VioletOakPlank);
        //Register Ores
        registerBlock(VirenOre);
        registerBlock(ScarRedOre);
        registerBlock(PinkSapphireOre);
        registerBlock(BlueTopazOre);
        registerBlock(RollYellowOre);
	}
    private static void registerBlock(Block block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName());
    }
}
