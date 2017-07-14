package violetcraft.world.biome;


import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import violetcraft.VioletCraftRegistry;
import violetcraft.entity.EntityMoonRabbit;

import java.util.Random;

public class BiomeGenViolet extends BiomeGenVioletBase {
    protected boolean generateLakes;

    public BiomeGenViolet(int localId) {
        super(localId);
        this.topBlock = VioletCraftRegistry.VioletGrassBlock;
        this.fillerBlock = VioletCraftRegistry.VioletDift;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMoonRabbit.class, 6, 1, 3));
        this.generateLakes = true;
    }
    @Override
    public WorldGenAbstractTree func_150567_a(Random par1Random) // getRandomWorldGenForTrees
    {
        return this.worldGeneratorTrees;
    }

}