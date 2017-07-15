package violetcraft.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import violetcraft.VioletCraftMod;

import java.util.Random;

public class BlockVirenOre extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;

    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;

    public BlockVirenOre()
    {
    	super(Material.rock);
        setCreativeTab(VioletCraftMod.VioletCradtTab);
        setBlockName("vc.virenOre");
        setBlockTextureName("violetcraft:viren_ore");
        setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        /*setBlockUnbreakable();*//*ブロックを破壊不可に設定*/
        /*setTickRandomly(true);*//*ブロックのtick処理をランダムに。デフォルトfalse*/
        /*disableStats();*//*ブロックの統計情報を保存しない*/
        setLightOpacity(1);/*ブロックの透過係数。デフォルト０（不透過）*/
        setLightLevel(0F);/*明るさ 1.0F = 15*/
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);/*当たり判定*/

//    	GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
    }

//    @Override
//    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ){
//        //ブロックを右クリックした際の動作
//        return true;
//    }
//
//    @Override
//    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
//        //ブロックを左クリックした際の動作
//    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock){
        //周囲のブロックが更新された際の動作
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random){
        //ドロップするアイテムを返す
        return quantityDroppedWithBonus(fortune, random);
    }

    @Override
    public int quantityDropped(Random random){
        //ドロップさせる量を返す
        return 1;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void registerBlockIcons(IIconRegister par1IconRegister)
//    {
//        this.TopIcon = par1IconRegister.registerIcon("violetcraft:VirenOre");
//        this.SideIcon = par1IconRegister.registerIcon("violetcraft:VirenOre");
//    }
//
//    @SideOnly(Side.CLIENT)
//    public IIcon getIcon(int par1, int par2)
//    {
//         if(par1 == 0 || par1 == 1)
//         {
//                  return TopIcon;
//         }
//         else
//         {
//                  return SideIcon;
//         }
//    }
}
