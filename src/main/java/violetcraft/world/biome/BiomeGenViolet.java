package violetcraft.world.biome;

import net.minecraft.init.Blocks;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import violetcraft.entity.EntityMoonRabbit;
import violetcraft.registry.ItemRegistry;

import java.util.Random;


public class BiomeGenViolet extends BiomeGenBase {
    protected boolean generateLakes;

    public BiomeGenViolet(int localId) {
        super(localId);
        this.topBlock = ItemRegistry.grassblock;
        this.fillerBlock = ItemRegistry.dift;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMoonRabbit.class, 3, 1, 3));
        this.generateLakes = true;
    }


    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return new WorldGenVioletGrass(ItemRegistry.grass,0);
    }
}