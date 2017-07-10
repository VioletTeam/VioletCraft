package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import violetcraft.tiles.TilEntityeTestMachine;
import violetcraft.tiles.TileEntityGenerator;
import violetcraft.tiles.TileEntityGuiBlock;

public class TileEntityRegistry
{
	public static void registry()
	{
		GameRegistry.registerTileEntity(TileEntityGuiBlock.class, "TileEntityGuiBlock");
		GameRegistry.registerTileEntity(TilEntityeTestMachine.class, "TilEntityeTestMachine");
		GameRegistry.registerTileEntity(TileEntityGenerator.class, "TileEntityGenerator");
	}
}
