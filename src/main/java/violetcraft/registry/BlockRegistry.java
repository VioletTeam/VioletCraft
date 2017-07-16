package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import violetcraft.block.BlockVirenBlock;
import violetcraft.block.VioletBush;
import violetcraft.block.dimension.*;
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
    public static final Block VioletGrassBlock = new BlockVioletGrass();
    public static final Block VioletGrass = new VioletBush();
    public static final Block VioletDift = new BlockVioletDift();
    public static final Block VioletPortal = new BlockVioletPortal();
    public static final Block VioletSapling = new BlockVioletSapling();
    public static final Block VioletLeave = new BlockVioletLeave();
    public static final Block VioletOakLog = new BlockVioletOakLog();
    public static final Block VioletOakPlank = new BlockVioletOakPlank();
    // Ore =============================================================================================================
    public static final Block RollYellowOre = new BlockRollYellowOre();
    public static final Block ScarRedOre = new BlockScarRedOre();
    public static final Block BlueTopazOre = new BlockBlueTopazOre();
    public static final Block PinkSapphireOre = new BlockPinkSapphireOre();
    public static final Block VirenOre = new BlockVirenOre();

	public static void addBlockRegistry() {
        //Register Blocks
        registerBlock(VirenBlock);
        registerBlock(Generator);
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
