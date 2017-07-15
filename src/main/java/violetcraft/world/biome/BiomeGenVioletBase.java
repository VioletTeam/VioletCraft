package violetcraft.world.biome;


import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import violetcraft.entity.EntityMoonRabbit;
import violetcraft.registry.ItemRegistry;
import violetcraft.world.biome.tree.WorldGenVioletTrees;

import java.util.Random;

public class BiomeGenVioletBase extends BiomeGenBase {
    public int treesPerChunk;
    protected WorldGenVioletTrees worldGeneratorTrees;

    public BiomeGenVioletBase(int localId) {
        super(localId);
        this.worldGeneratorTrees = new WorldGenVioletTrees(false);
        this.treesPerChunk = 0;

        this.topBlock = ItemRegistry.violetgrassblock;
        this.fillerBlock = ItemRegistry.violetdift;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityMoonRabbit.class, 6, 1, 3));
    }

    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_) {
        return new WorldGenVioletGrass(ItemRegistry.violetgrass, 0);
    }

    /*メゾットがいじれないやつなので気をつけて*/
    @Override
    public WorldGenAbstractTree func_150567_a(Random par1Random) // getRandomWorldGenForTrees
    {
        return this.worldGeneratorTrees;
    }
}
