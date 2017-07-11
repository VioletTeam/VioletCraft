package violetcraft.world;


import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import violetcraft.VioletCraftMod;

public class WorldProviderViolet extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Sample";
    }

    // 独自のワールドタイプやワールドチャンクマネージャーを設定
    @Override
    protected void registerWorldChunkManager() {
        worldObj.getWorldInfo().setTerrainType(WorldTypeViolet.worldTypeSample);
        worldChunkMgr = new WorldChunkManagerSample(worldObj);
        setDimension(VioletCraftMod.dimensionID);
        hasNoSky = false;
    }

    // チャンク生成は独自のチャンクプロバイダが担当する
    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderSample(worldObj, worldObj.getSeed(), true);
    }
}
