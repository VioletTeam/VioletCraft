package violetcraft.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftRegistry;

public class VioletBush extends BlockBush {
    public VioletBush() {
        super(Material.vine);
        setCreativeTab(VioletCraftRegistry.tabVioletCraft);
        setBlockName("VioletBash");
        setBlockTextureName("violetcraft:violetgrass");
        setStepSound(Block.soundTypeGrass);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    @Override
    protected boolean canPlaceBlockOn(Block parBlock){
        return  parBlock == VioletCraftRegistry.VioletGrassBlock || parBlock == VioletCraftRegistry.VioletDift;
    }
}