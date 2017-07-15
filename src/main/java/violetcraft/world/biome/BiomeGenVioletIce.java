package violetcraft.world.biome;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;


public class BiomeGenVioletIce extends BiomeGenVioletBase {
    protected boolean generateLakes;


    public BiomeGenVioletIce(int localId) {
        super(localId);
        this.enableSnow = true;
        this.treesPerChunk = 9;
    }


    @Override
    public WorldGenAbstractTree func_150567_a(Random par1Random) // getRandomWorldGenForTrees
    {
        return this.worldGeneratorTrees;
    }
}