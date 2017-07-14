package violetcraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import violetcraft.VioletCraftRegistry;
import violetcraft.entity.EntityMoonRabbit;

import java.util.Random;


public class BiomeGenViolet extends BiomeGenBase {
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


    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_) {
        return new WorldGenVioletGrass(VioletCraftRegistry.VioletGrass, 0);
    }

}