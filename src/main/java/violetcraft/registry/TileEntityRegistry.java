package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import violetcraft.tileentity.TilEntityeTestMachine;
import violetcraft.tileentity.TileEntityGenerator;
import violetcraft.tileentity.TileEntityGuiBlock;

public class TileEntityRegistry
{
	public static void registry()
	{
		GameRegistry.registerTileEntity(TileEntityGuiBlock.class, "TileEntityGuiBlock");
		GameRegistry.registerTileEntity(TilEntityeTestMachine.class, "TilEntityeTestMachine");
		GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");
	}
}
