package violetcraft.block;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import violetcraft.VioletCraftMod;

public class VioletDift extends Block
{
    public VioletDift()
    {
        super(Material.ground);

        setCreativeTab(VioletCraftMod.VioletCradtTab);
        setBlockName("VioletDift");
        setBlockTextureName("violetcraft:violetdift");
        setHardness(0.5F);
        setResistance(2.5F);
        setStepSound(Block.soundTypeGravel);
        GameRegistry.registerBlock(this, "VioletDift");
    }
}