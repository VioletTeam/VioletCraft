package violetcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import violetcraft.VioletCraftMod;
import violetcraft.registry.ItemRegistry;

import java.util.Random;


public class BlockVioletGrass extends Block
{
    private IIcon field_149991_b;
    @SideOnly(Side.CLIENT)
    private IIcon field_149993_M;
    public BlockVioletGrass()
    {
        super(Material.grass);
        String name = "VioletGrassBlock";
        setCreativeTab(VioletCraftMod.VioletCradtTab);
        setBlockTextureName("violetcraft:violetdift");
        setBlockName(name);
        setHardness(0.5F);
        setResistance(2.5F);
        setStepSound(Block.soundTypeGrass);
        GameRegistry.registerBlock(this, name);
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149991_b : (p_149691_1_ == 0 ? ItemRegistry.dift.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!p_149674_1_.isRemote)
        {
            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2)
            {
                p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, ItemRegistry.dift);
            }
            else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
                    int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
                    int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
                    Block block = p_149674_1_.getBlock(i1, j1 + 1, k1);

                    if (p_149674_1_.getBlock(i1, j1, k1) == ItemRegistry.dift && p_149674_1_.getBlockMetadata(i1, j1, k1) == 0 && p_149674_1_.getBlockLightValue(i1, j1 + 1, k1) >= 4 && p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        p_149674_1_.setBlock(i1, j1, k1, ItemRegistry.grassblock);
                    }
                }
            }
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ItemRegistry.dift.getItemDropped(0, p_149650_2_, p_149650_3_);
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
        if (p_149673_5_ == 1) {
            return this.field_149991_b;
        } else if(p_149673_5_ == 0)
        {
            return ItemRegistry.dift.getBlockTextureFromSide(p_149673_5_);
        }else
        {
            Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.field_149991_b;
        }
    }
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName() + "_side");
        this.field_149991_b = p_149651_1_.registerIcon(this.getTextureName() + "_top");
    }
}