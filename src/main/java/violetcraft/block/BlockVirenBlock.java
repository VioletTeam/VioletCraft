package violetcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class BlockVirenBlock extends Block {

	/**
	 * ヴァイレンブロック
	 */
    public BlockVirenBlock()
    {
    	super(Material.rock);
        setCreativeTab(VioletCraftMod.tabVioletCraft);
        setBlockName("virenBlock");
        setBlockTextureName("violetcraft:viren_block");
        setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
}
