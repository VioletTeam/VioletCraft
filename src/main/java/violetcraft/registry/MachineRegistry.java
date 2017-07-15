package violetcraft.registry;

import net.minecraft.block.Block;
import violetcraft.block.machine.BlockGenerator;
import violetcraft.item.ItemTestMachine;

public class MachineRegistry
{

	public static Block TestMachine;
    public static Block blockGenerator;

	public static void registry()
	{
		TestMachine = new ItemTestMachine();
        blockGenerator = new BlockGenerator();
    }
}
