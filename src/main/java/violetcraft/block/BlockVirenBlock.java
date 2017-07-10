package violetcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class BlockVirenBlock extends Block {

	/**
	 * ヴァイレンブロック
	 *
	 * @param name 名前
	 */
    public BlockVirenBlock(String name)
    {
    	super(Material.rock);
    	setCreativeTab(VioletCraftMod.VioletCradtMod);
    	setBlockName(name);
	    setBlockTextureName("violetcraft:block_viren_block");
	    setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);

        GameRegistry.registerBlock(this, name);
    }
}
