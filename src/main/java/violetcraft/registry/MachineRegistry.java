package violetcraft.registry;

import net.minecraft.block.Block;
import violetcraft.block.BlockMusicGenerator;
import violetcraft.item.ItemTestMachine;

public class MachineRegistry
{

	public static Block TestMachine;
	public static Block BlockGenerator;

	public static void registry()
	{
		TestMachine = new ItemTestMachine();
		BlockGenerator = new BlockMusicGenerator();
	}
}
