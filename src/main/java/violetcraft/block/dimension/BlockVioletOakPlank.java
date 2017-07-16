package violetcraft.block.dimension;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;


public class BlockVioletOakPlank extends Block {
    public BlockVioletOakPlank() {
        super(Material.wood);
        this.setCreativeTab(VioletCraftMod.tabVioletCraft);
        this.setBlockName("VioletPlank");
        this.setBlockTextureName("violetcraft:planks_violet");
        this.setHardness(2F);
        this.setResistance(12F);
        this.setStepSound(Block.soundTypeWood);
    }
}
