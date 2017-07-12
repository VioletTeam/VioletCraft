package violetcraft.block;



import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import violetcraft.VioletCraftMod;
import violetcraft.registry.ItemRegistry;

public class VioletGrass extends BlockBush
{
    public VioletGrass()
    {
        super(Material.vine);
        setCreativeTab(VioletCraftMod.VioletCradtTab);
        setBlockName("VioletGrass");
        setBlockTextureName("violetcraft:violetgrass");
        GameRegistry.registerBlock(this, "VioletGrass");
        setStepSound(Block.soundTypeGrass);
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
    }
    @Override
    protected boolean canPlaceBlockOn(Block parBlock)
    {
        return parBlock == ItemRegistry.grassblock;
    }
}