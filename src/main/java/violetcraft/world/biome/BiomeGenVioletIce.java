package violetcraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import violetcraft.VioletCraftRegistry;
import violetcraft.entity.EntityMoonRabbit;

import java.util.Random;


public class BiomeGenVioletIce extends BiomeGenVioletBase {
    protected boolean generateLakes;


    public BiomeGenVioletIce(int localId) {
        super(localId);
        this.enableSnow = true;
        this.treesPerChunk = 8;
    }


    @Override
    public WorldGenAbstractTree func_150567_a(Random par1Random) // getRandomWorldGenForTrees
    {
        return this.worldGeneratorTrees;
    }
}