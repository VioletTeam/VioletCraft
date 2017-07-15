package violetcraft.world.biome;


import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import violetcraft.VioletCraftRegistry;

import java.util.Random;

public class BiomeGenViolet extends BiomeGenVioletBase {
    protected boolean generateLakes;

    public BiomeGenViolet(int localId) {
        super(localId);
        this.generateLakes = true;
        this.treesPerChunk = 5;
    }

    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_) {
        return new WorldGenVioletGrass(VioletCraftRegistry.VioletGrass, 0);
    }

    @Override
    public WorldGenAbstractTree func_150567_a(Random par1Random) // getRandomWorldGenForTrees
    {
        return this.worldGeneratorTrees;
    }

}