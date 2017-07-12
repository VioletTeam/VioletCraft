package violetcraft.world;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import violetcraft.VioletCraftMod;

public class WorldProviderViolet extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Violet";
    }

    // 独自のワールドタイプやワールドチャンクマネージャーを設定
    @Override
    protected void registerWorldChunkManager() {
        worldObj.getWorldInfo().setTerrainType(WorldTypeViolet.worldTypeSample);
        worldChunkMgr = new WorldChunkManagerViolet(worldObj);
        setDimension(VioletCraftMod.dimensionID);
        hasNoSky = false;
    }

    // チャンク生成は独自のチャンクプロバイダが担当する
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderViolet(worldObj, worldObj.getSeed(), true);
    }
    /** このディメンションの空の色を返す。 */
    @Override
    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float par1, float par2) {
        return Vec3.createVectorHelper(0.5D, 0.5D, 0.5D);
    }


    /** 朝焼け・夕焼けの色を返す。
     * @return null */
    @Override
    @SideOnly(Side.CLIENT)
    public float[] calcSunriseSunsetColors(float par1, float par2) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long par1, float par2) {
        return 0.0F;
    }
    /** 空に色が付いているかを返す。(?)
     * @return false */
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

}
