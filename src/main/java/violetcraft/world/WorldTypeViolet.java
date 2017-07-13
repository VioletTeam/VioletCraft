package violetcraft.world;


import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldTypeViolet extends WorldType {

    public static WorldType worldTypeSample = new WorldTypeViolet("Violet");

    private WorldTypeViolet(String name) {
        super(name);
    }

    @Override
    public WorldChunkManager getChunkManager(World world) {
        return new WorldChunkManagerViolet(world);
    }
}