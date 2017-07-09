package violetcraft.registry;

import net.minecraft.block.Block;
import violetcraft.block.BlockGenerator;
import violetcraft.items.machine.TestMachine;

public class MachineRegistry
{

	public static Block TestMachine;
	public static Block BlockGenerator;

	public static void registry()
	{
		TestMachine = new TestMachine();
		BlockGenerator = new BlockGenerator();
	}
}
