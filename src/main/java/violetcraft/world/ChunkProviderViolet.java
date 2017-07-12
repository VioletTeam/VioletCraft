package violetcraft.world;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;


public class ChunkProviderViolet extends ChunkProviderGenerate implements IChunkProvider {

    public ChunkProviderViolet(World par1World, long par2, boolean par4) {
        super(par1World, par2, par4);
    }

}