package violetcraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import violetcraft.world.biome.BiomeGenViolet;
import violetcraft.world.biome.BiomeGenVioletIce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class WorldChunkManagerViolet extends WorldChunkManager {

    public static final BiomeGenBase[] biomeList = new BiomeGenBase[256];
    public static int biomevioletID = 80;
    public static int biomevioletID2 = 81;
    // WorldChunkManagerのプライベート変数にはアクセスできないので専用の変数を作成
    private GenLayer genBiomes;
    private GenLayer biomeIndexLayer;
    private BiomeCache biomeCache;
    private List biomesToSpawnIn;
    private BiomeGenBase plainviolet = (new BiomeGenViolet(biomevioletID));
    private BiomeGenBase iceviolet = (new BiomeGenVioletIce(biomevioletID2));
    // 独自ディメンションにはメサとキノコバイオームのみ
    private ArrayList<BiomeGenBase> allowedBiomes = new ArrayList<BiomeGenBase>(Arrays.asList(plainviolet, iceviolet));

    {
        for (int i = 0; i < 256; ++i) {
            if (i % 2 == 0) {
                biomeList[i] = plainviolet;
            } else if (i % 2 == 1) {
                biomeList[i] = iceviolet;
            }
        }
    }

    protected WorldChunkManagerViolet() {
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = new ArrayList();
        this.biomesToSpawnIn.addAll(allowedBiomes);
    }

    public WorldChunkManagerViolet(long par1, WorldType par3WorldType) {
        this();
        GenLayer[] var4 = GenLayer.initializeAllBiomeGenerators(par1, par3WorldType);
        this.genBiomes = var4[0];
        this.biomeIndexLayer = var4[1];
    }

    public WorldChunkManagerViolet(World par1World) {
        this(par1World.getSeed(), par1World.getWorldInfo().getTerrainType());
    }

    ///////////////////////////////////////////////////////////////////////
    // WorldChunkManagerのプライベート変数を使用するメソッドはすべて再実装

    @Override
    public List getBiomesToSpawnIn() {
        return this.biomesToSpawnIn;
    }

    @Override
    public BiomeGenBase getBiomeGenAt(int par1, int par2) {
        return this.biomeCache.getBiomeGenAt(par1, par2);
    }

    @Override
    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5) {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        int[] var6 = this.biomeIndexLayer.getInts(par2, par3, par4, par5);

        for (int var7 = 0; var7 < par4 * par5; ++var7) {
            float var8 = (float) biomeList[var6[var7]].getIntRainfall() / 65536.0F;

            if (var8 > 1.0F) {
                var8 = 1.0F;
            }

            par1ArrayOfFloat[var7] = var8;
        }

        return par1ArrayOfFloat;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public float getTemperatureAtHeight(float par1, int par2) {
        return par1;
    }

    @Override
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        int[] var6 = this.genBiomes.getInts(par2, par3, par4, par5);

        for (int var7 = 0; var7 < par4 * par5; ++var7) {
            par1ArrayOfBiomeGenBase[var7] = biomeList[var6[var7]];
        }

        return par1ArrayOfBiomeGenBase;
    }

    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
        return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }

    @Override
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6) {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0) {
            BiomeGenBase[] var9 = this.biomeCache.getCachedBiomes(par2, par3);
            System.arraycopy(var9, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        } else {
            int[] var7 = this.biomeIndexLayer.getInts(par2, par3, par4, par5);

            for (int var8 = 0; var8 < par4 * par5; ++var8) {
                par1ArrayOfBiomeGenBase[var8] = biomeList[var7[var8]];
            }

            return par1ArrayOfBiomeGenBase;
        }
    }

    @Override
    public boolean areBiomesViable(int par1, int par2, int par3, List par4List) {
        IntCache.resetIntCache();
        int var5 = par1 - par3 >> 2;
        int var6 = par2 - par3 >> 2;
        int var7 = par1 + par3 >> 2;
        int var8 = par2 + par3 >> 2;
        int var9 = var7 - var5 + 1;
        int var10 = var8 - var6 + 1;
        int[] var11 = this.genBiomes.getInts(var5, var6, var9, var10);

        for (int var12 = 0; var12 < var9 * var10; ++var12) {
            BiomeGenBase var13 = biomeList[var11[var12]];

            if (!par4List.contains(var13)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random) {
        IntCache.resetIntCache();
        int var6 = par1 - par3 >> 2;
        int var7 = par2 - par3 >> 2;
        int var8 = par1 + par3 >> 2;
        int var9 = par2 + par3 >> 2;
        int var10 = var8 - var6 + 1;
        int var11 = var9 - var7 + 1;
        int[] var12 = this.genBiomes.getInts(var6, var7, var10, var11);
        ChunkPosition var13 = null;
        int var14 = 0;

        for (int var15 = 0; var15 < var10 * var11; ++var15) {
            int var16 = var6 + var15 % var10 << 2;
            int var17 = var7 + var15 / var10 << 2;
            BiomeGenBase var18 = biomeList[var12[var15]];

            if (par4List.contains(var18) && (var13 == null || par5Random.nextInt(var14 + 1) == 0)) {
                var13 = new ChunkPosition(var16, 0, var17);
                ++var14;
            }
        }

        return var13;
    }

    @Override
    public void cleanupCache() {
        this.biomeCache.cleanupCache();
    }
}