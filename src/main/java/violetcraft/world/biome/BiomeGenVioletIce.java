package violetcraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import violetcraft.VioletCraftRegistry;
import violetcraft.entity.EntityMoonRabbit;
import violetcraft.world.biome.tree.WorldGenVioletTrees;

import java.util.Random;


public class BiomeGenVioletIce extends BiomeGenBase {

    private final int treesPerChunk;
    protected WorldGenVioletTrees worldGeneratorTrees;
    public BiomeGenVioletIce(int localId) {
        super(localId);
        this.worldGeneratorTrees=new WorldGenVioletTrees(false);
        this.treesPerChunk = 4;

        this.topBlock = VioletCraftRegistry.VioletGrassBlock;
        this.fillerBlock = VioletCraftRegistry.VioletDift;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityMoonRabbit.class, 6, 1, 3));
        this.enableSnow=true;
    }
    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return new WorldGenVioletGrass(VioletCraftRegistry.VioletGrass, 0);
    }
    /*メゾットがいじれないやつなので気をつけて*/
    @Override
    public WorldGenAbstractTree func_150567_a(Random par1Random) // getRandomWorldGenForTrees
    {
        return this.worldGeneratorTrees;
    }


}