package violetcraft.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class BlockScarRedOre extends Block {
    public BlockScarRedOre() {
        super(Material.rock);

        setCreativeTab(VioletCraftMod.tabVioletCraft);
        setBlockName("scarRedOre");
        setBlockTextureName("violetcraft:scar_red_ore");
        setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightOpacity(1);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
}
