package violetcraft.block.dimension;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import violetcraft.VioletCraftMod;
import violetcraft.world.VioletTeleporter;


public class BlockVioletPortal extends Block {
    private IIcon[] iicon = new IIcon[2];

    public BlockVioletPortal() {
        super(Material.portal);
        this.setHardness(25.0F);
        this.setResistance(300.0F);
        this.setStepSound(soundTypePiston);
        this.setHarvestLevel("pickaxe", 2);
        this.setLightLevel(1.0F);
        this.setBlockName("VioletPortal");
        this.setBlockTextureName("violetcraft:violetportal");
    }


    /**
     * 硬さを返す。
     */
    @Override
    public float getBlockHardness(World world, int x, int y, int z) {

        return 25.0F;
    }


    /**
     * 右クリックされたときの処理。
     */
    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        // 現在地が独自ディメンション以外
        if (p_149727_1_.provider.dimensionId != VioletCraftMod.dimensionID) {
            if (p_149727_5_ instanceof EntityPlayerMP) {
                // １行で書くと長過ぎるので一旦ローカル変数に格納
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP) p_149727_5_;
                ServerConfigurationManager serverConfigurationManager = entityPlayerMP.mcServer.getConfigurationManager();
                WorldServer worldServer = entityPlayerMP.mcServer.worldServerForDimension(VioletCraftMod.dimensionID);

                // 移動後にネザーポータルが作成されるので即座に再送還されないように
                entityPlayerMP.timeUntilPortal = 10;
                //entityPlayerMP.getPortalCooldown();

                // 独自ディメンションに移動する
                serverConfigurationManager.transferPlayerToDimension(entityPlayerMP, VioletCraftMod.dimensionID, new VioletTeleporter(worldServer));
            }
        }
        // 現在地が独自ディメンション
        else {
            if (p_149727_5_ instanceof EntityPlayerMP) {
                // １行で書くと長過ぎるので一旦ローカル変数に格納
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP) p_149727_5_;
                ServerConfigurationManager serverConfigurationManager = entityPlayerMP.mcServer.getConfigurationManager();

                entityPlayerMP.timeUntilPortal = 10;

                // 独自ディメンションからはオーバーワールドに移動
                serverConfigurationManager.transferPlayerToDimension(entityPlayerMP, 0);
            }
        }
        return true;
    }


}