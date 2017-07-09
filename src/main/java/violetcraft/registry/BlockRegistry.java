package violetcraft.registry;

import net.minecraft.block.Block;
import violetcraft.block.BlockVirenBlock;

public class BlockRegistry {

	public static Block BlockVirenBlock;

	public static void blockRegistry()
	{
		BlockVirenBlock = new BlockVirenBlock("block_viren_block");
	}
}
