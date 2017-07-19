package violetcraft.block.ore;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import violetcraft.VioletCraftMod;

public class BlockBlueTopazOre extends Block {

	private Random random = new Random();

	/**
	 * 蒼玉鉱石
	 * Blue Topaz Ore
	 *
	 * @param name アイテム名
	 */
    public BlockBlueTopazOre(String name) {
        super(Material.rock);
        setCreativeTab(VioletCraftMod.tabVioletCraft);
        setBlockName(name);
        setBlockTextureName("violetcraft:" + name);
        setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightOpacity(1);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * 経験値のドロップ量を返す。
     */
    @Override
    public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
    	return MathHelper.getRandomIntegerInRange(random, 3, 7);
    }
}
