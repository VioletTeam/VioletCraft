package violetcraft.world;


import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class VioletTeleporter extends Teleporter {

    public VioletTeleporter(WorldServer p_i1963_1_) {
        super(p_i1963_1_);
    }

    // 近くにポータルがあったらそこに出現させる処理
    // このサンプルではネザーポータルの処理をそのまま利用する
    @Override
    public boolean placeInExistingPortal(Entity p_77184_1_, double p_77184_2_, double p_77184_4_, double p_77184_6_, float p_77184_8_) {
        return super.placeInExistingPortal(p_77184_1_, p_77184_2_, p_77184_4_, p_77184_6_, p_77184_8_);
    }

    // ポータルを作成する処理
    // このサンプルではネザーポータルの処理をそのまま利用する
    @Override
    public boolean makePortal(Entity p_85188_1_) {
        return super.makePortal(p_85188_1_);
    }

    // プレイヤーをポータルに出現させる処理
    // このサンプルではネザーポータルの処理をそのまま利用する
    @Override
    public void placeInPortal(Entity p_77185_1_, double p_77185_2_, double p_77185_4_, double p_77185_6_, float p_77185_8_) {
        super.placeInPortal(p_77185_1_, p_77185_2_, p_77185_4_, p_77185_6_, p_77185_8_);
    }
}