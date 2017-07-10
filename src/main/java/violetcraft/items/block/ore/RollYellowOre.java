package violetcraft.items.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftRegistry;

public class RollYellowOre extends Block
{
	public RollYellowOre()
	{
		super(Material.rock);

		setCreativeTab(VioletCraftRegistry.VioletCraftMod);
		setBlockName("RollYellowOre");
		setBlockTextureName("violetcraft:RollYellow_Ore");
	    setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightOpacity(1);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
}
