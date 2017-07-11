package violetcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class BlockRollYellowOre extends Block
{
	public BlockRollYellowOre()
	{
		super(Material.rock);

		setCreativeTab(VioletCraftMod.VioletCradtTab);
		setBlockName("RollYellowOre");
		setBlockTextureName("violetcraft:RollYellow_Ore");
	    setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightOpacity(1);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        GameRegistry.registerBlock(this, "RollYellowOre");
	}
}