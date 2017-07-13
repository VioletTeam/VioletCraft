package violetcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import violetcraft.VioletCraftMod;
import violetcraft.registry.ItemRegistry;

import java.util.Random;


public class BlockVioletGrass extends Block
{
    private IIcon field_149991_b;
    public BlockVioletGrass()
    {
        super(Material.ground);

        setCreativeTab(VioletCraftMod.VioletCradtTab);
        setBlockName("VioletDift");
        setHardness(0.5F);
        setResistance(2.5F);
        setStepSound(Block.soundTypeGravel);
        GameRegistry.registerBlock(this, "VioletDift");
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149991_b : (p_149691_1_ == 0 ? Blocks.dirt.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ItemRegistry.getItemDropped(0, p_149650_2_, p_149650_3_);
    }
}