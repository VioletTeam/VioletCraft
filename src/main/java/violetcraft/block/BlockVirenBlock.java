package violetcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftRegistry;

public class BlockVirenBlock extends Block {

	/**
	 * ヴァイレンブロック
	 *
	 * @param name 名前
	 */
    public BlockVirenBlock(String name)
    {
    	super(Material.rock);
        setCreativeTab(VioletCraftRegistry.VioletCraftMod);
        setBlockName(name);
	    setBlockTextureName("violetcraft:block_viren_block");
	    setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
}
