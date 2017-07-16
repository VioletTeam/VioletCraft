package violetcraft.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftRegistry;

public class BlockBlueTopazOre extends Block {
    public BlockBlueTopazOre() {
        super(Material.rock);
        setCreativeTab(VioletCraftRegistry.tabVioletCraft);
        setBlockName("vc.blueTopazOre");
        setBlockTextureName("violetcraft:blue_topaz_ore");
        setHardness(1.5F);
        setResistance(1.0F);
        setStepSound(Block.soundTypeStone);
        setLightOpacity(1);
        setLightLevel(0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
}
