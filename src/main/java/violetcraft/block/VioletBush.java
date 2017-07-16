package violetcraft.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;
import violetcraft.registry.BlockRegistry;

public class VioletBush extends BlockBush {
    public VioletBush() {
        super(Material.vine);
        setCreativeTab(VioletCraftMod.tabVioletCraft);
        setBlockName("VioletBash");
        setBlockTextureName("violetcraft:violetgrass");
        setStepSound(Block.soundTypeGrass);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }

    @Override
    protected boolean canPlaceBlockOn(Block parBlock) {
        return parBlock == BlockRegistry.VioletGrassBlock || parBlock == BlockRegistry.VioletDift;
    }
}