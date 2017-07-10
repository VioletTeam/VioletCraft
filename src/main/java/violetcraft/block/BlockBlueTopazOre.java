package violetcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class BlockBlueTopazOre extends Block
{
	public BlockBlueTopazOre()
	{
		super(Material.rock);

		setCreativeTab(VioletCraftMod.VioletCradtMod);
		setBlockName("BlueTopazOre");
		setBlockTextureName("violetcraft:BlueTopaz_Ore");
	    setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightOpacity(1);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        GameRegistry.registerBlock(this, "BlueTopazOre");
	}
}
