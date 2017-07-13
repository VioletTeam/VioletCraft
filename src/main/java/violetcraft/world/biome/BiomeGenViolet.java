package violetcraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import violetcraft.entity.EntityMoonRabbit;
import violetcraft.registry.ItemRegistry;

import java.util.Random;


public class BiomeGenViolet extends BiomeGenBase {
    protected boolean generateLakes;

    public BiomeGenViolet(int localId) {
        super(localId);
        this.topBlock = ItemRegistry.violetgrassblock;
        this.fillerBlock = ItemRegistry.violetdift;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMoonRabbit.class, 6, 1, 3));
        this.generateLakes = true;
    }


    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return new WorldGenVioletGrass(ItemRegistry.violetgrass,0);
    }

}