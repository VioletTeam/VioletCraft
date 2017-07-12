package violetcraft.block;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import violetcraft.VioletCraftMod;
import violetcraft.world.VioletTeleporter;


import java.util.Random;

public class BlockVioletPortal extends Block {
    private IIcon[] iicon = new IIcon[2];

    public BlockVioletPortal() {
        super(Material.rock);
        this.setHardness(25.0F);
        this.setResistance(6000000.0F);
        this.setStepSound(soundTypePiston);
        this.setHarvestLevel("pickaxe", 2);
        this.setLightLevel(1.0F);
        this.setBlockName("VioletPortal");
        this.setBlockTextureName("violetcraft:violetportal");
        GameRegistry.registerBlock(this, "VioletPortal");
    }

    /** ドロップアイテムを返す。 */
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        if (meta == 1)
            return null;
        return Item.getItemFromBlock(this);
    }

    /** 硬さを返す。 */
    @Override
    public float getBlockHardness(World world, int x, int y, int z) {

        return 25.0F;
    }


    /** 右クリックされたときの処理。 */
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