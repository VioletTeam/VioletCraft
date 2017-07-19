package violetcraft.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class BlockPinkSapphireOre extends Block {
    public BlockPinkSapphireOre(String name) {
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
}
