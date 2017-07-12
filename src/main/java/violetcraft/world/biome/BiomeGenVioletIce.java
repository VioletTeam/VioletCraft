package violetcraft.world.biome;

import javafx.scene.LightBase;
import javafx.scene.image.PixelWriter;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.w3c.dom.css.CSS2Properties;
import org.w3c.dom.html.HTMLBaseFontElement;
import org.w3c.dom.html.HTMLFontElement;
import violetcraft.entity.EntityMoonRabbit;
import violetcraft.registry.ItemRegistry;

import java.util.Random;


public class BiomeGenVioletIce extends BiomeGenBase {
    protected boolean worldGeneratorTrees;
    protected boolean generateLakes;



    public BiomeGenVioletIce(int localId) {
        super(localId);
        this.topBlock = ItemRegistry.grassblock;
        this.fillerBlock = ItemRegistry.dift;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityMoonRabbit.class, 3, 1, 3));
        this.generateLakes = true;
        this.enableSnow = true;
        this.worldGeneratorTrees= true;
    }



    public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return new WorldGenVioletGrass(ItemRegistry.grass,0);
    }
}