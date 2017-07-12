package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import violetcraft.block.BlockVirenBlock;

public class BlockRegistry {

	public static Block BlockVirenBlock;

	public static void blockRegistry()
	{
    	BlockVirenBlock = GameRegistry.registerBlock(new BlockVirenBlock(), "block_viren_block");
	}
}
