package violetcraft.block;



import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;
import violetcraft.registry.BlockRegistry;

public class VioletGrass extends BlockBush
{
    public VioletGrass()
    {
        super(Material.vine);
        setCreativeTab(VioletCraftMod.tabVioletCraft);
        setBlockName("VioletGrass");
        setBlockTextureName("violetcraft:violetgrass");
        setStepSound(Block.soundTypeGrass);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }
    @Override
    protected boolean canPlaceBlockOn(Block block)
    {
        return block == BlockRegistry.VioletGrassBlock || block == BlockRegistry.VioletDift;
    }
}