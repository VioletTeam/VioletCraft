package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import violetcraft.tile.TileGenerator;
import violetcraft.tile.TileGuiBlock;

public class TileEntityRegistry
{
	public static void addTileEntityregistry()
	{
		GameRegistry.registerTileEntity(TileGuiBlock.class, "TileGuiBlock");
		GameRegistry.registerTileEntity(TileGenerator.class, "TileGenerator");


	}
}
