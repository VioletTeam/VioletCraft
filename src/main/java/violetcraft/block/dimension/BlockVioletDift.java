package violetcraft.block.dimension;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftRegistry;

public class BlockVioletDift extends Block {
    public BlockVioletDift() {
        super(Material.ground);

        setCreativeTab(VioletCraftRegistry.tabVioletCraft);
        setBlockName("VioletDift");
        setBlockTextureName("violetcraft:violetdift");
        setHardness(0.5F);
        setResistance(2.5F);
        setStepSound(Block.soundTypeGravel);
    }
}