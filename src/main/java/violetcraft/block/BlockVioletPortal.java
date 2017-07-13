package violetcraft.block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import violetcraft.VioletCraftMod;
import violetcraft.world.VioletTeleporter;

import static net.minecraft.block.BlockPortal.func_149999_b;

public class BlockVioletPortal extends Block {

    protected BlockVioletPortal(Material p_i45394_1_,String name) {
        super(p_i45394_1_);
        setBlockName(name);
        setBlockTextureName("violetcraft:violetportal");
        setHardness(1.0F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightLevel(1.5F);
        setBlockName("violetportal");
    }
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        int l = func_149999_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));

        if (l == 0)
        {
            if (p_149719_1_.getBlock(p_149719_2_ - 1, p_149719_3_, p_149719_4_) != this && p_149719_1_.getBlock(p_149719_2_ + 1, p_149719_3_, p_149719_4_) != this)
            {
                l = 2;
            }
            else
            {
                l = 1;
            }

            if (p_149719_1_ instanceof World && !((World)p_149719_1_).isRemote)
            {
                ((World)p_149719_1_).setBlockMetadataWithNotify(p_149719_2_, p_149719_3_, p_149719_4_, l, 2);
            }
        }

        float f = 0.125F;
        float f1 = 0.125F;

        if (l == 1)
        {
            f = 0.5F;
        }

        if (l == 2)
        {
            f1 = 0.5F;
        }

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }

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
                entityPlayerMP.setInPortal();
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

                entityPlayerMP.setInPortal();
                //entityPlayerMP.timeUntilPortal = 10;

                // 独自ディメンションからはオーバーワールドに移動
                serverConfigurationManager.transferPlayerToDimension(entityPlayerMP, 0);
            }
        }
        return true;
    }

}