package violetcraft.block.ore;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import violetcraft.VioletCraftMod;

public class BlockVirenOre extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon TopIcon;

    @SideOnly(Side.CLIENT)
    private IIcon SideIcon;

    public BlockVirenOre()
    {
    	super(Material.rock);
        setCreativeTab(VioletCraftMod.tabVioletCraft);
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
    }

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
}
