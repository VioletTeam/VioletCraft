package violetcraft.block.dimension;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class BlockVioletDift extends Block {
    public BlockVioletDift() {
        super(Material.ground);

        setCreativeTab(VioletCraftMod.VioletCradtTab);
        setBlockName("VioletDift");
        setBlockTextureName("violetcraft:violetdift");
        setHardness(0.5F);
        setResistance(2.5F);
        setStepSound(Block.soundTypeGravel);
    }
}