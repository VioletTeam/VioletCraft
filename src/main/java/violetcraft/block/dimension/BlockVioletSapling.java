package violetcraft.block.dimension;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;
import violetcraft.VioletCraftMod;
import violetcraft.registry.BlockRegistry;
import violetcraft.world.biome.tree.WorldGenVioletTrees;
import violetcraft.world.biome.tree.WorldGenVioletTreesBase;

public class BlockVioletSapling extends BlockFlower {
    public static final String[] WOOD_TYPES = new String[]{"violetoak"};
    private IIcon[] icons;


    public BlockVioletSapling() {
        super(0);
        float var3 = 0.4F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
        this.setCreativeTab(VioletCraftMod.tabVioletCraft);
        setBlockName("VioletSapling");
        setStepSound(Block.soundTypeGrass);
    }

    @Override
    public boolean canReplace(World par1World, int par2, int par3, int par4, int par5, ItemStack par6ItemStack) {

        Block block = par1World.getBlock(par2, par3 - 1, par4);
        return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World.canBlockSeeTheSky(par2, par3, par4)) &&
                (block == BlockRegistry.VioletGrassBlock || block == BlockRegistry.VioletDift);

    }

    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
        Block block = par1World.getBlock(par2, par3 - 1, par4);
        return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World.canBlockSeeTheSky(par2, par3, par4)) &&
                (block == BlockRegistry.VioletGrassBlock || block == BlockRegistry.VioletDift);

    }


    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!par1World.isRemote) {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0) {
                int var6 = par1World.getBlockMetadata(par2, par3, par4);

                if ((var6 & 8) == 0) {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 8, 3);
                } else {
                    this.growTree(par1World, par2, par3, par4, par5Random);
                }
            }
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    /**
     * Attempts to grow a sapling into a tree
     */
    public void growTree(World par1World, int par2, int par3, int par4, Random par5Random) {
        if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;

        int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
        WorldGenVioletTreesBase var7 = null;
        int var8 = 0;
        int var9 = 0;
        boolean var10 = false;

            /*violetの木*/
        var7 = new WorldGenVioletTrees(true);

        if (var10) {
            par1World.setBlockToAir(par2 + var8, par3, par4 + var9);
            par1World.setBlockToAir(par2 + var8 + 1, par3, par4 + var9);
            par1World.setBlockToAir(par2 + var8, par3, par4 + var9 + 1);
            par1World.setBlockToAir(par2 + var8 + 1, par3, par4 + var9 + 1);
        } else {
            par1World.setBlockToAir(par2, par3, par4);
        }

        if (!var7.generate(par1World, par5Random, par2 + var8, par3, par4 + var9)) {
            if (var10) {
                par1World.setBlock(par2 + var8, par3, par4 + var9, this, var6, 3);
                par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, this, var6, 3);
                par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, this, var6, 3);
                par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, this, var6, 3);
            } else {
                par1World.setBlock(par2, par3, par4, this, var6, 3);
            }
        }
    }

    /**
     * Determines if the same sapling is present at the given location.
     */
    public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5) {
        return par1World.getBlock(par2, par3, par4) == this && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */


    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister) {
        this.icons = new IIcon[WOOD_TYPES.length];
        for (int i = 0; i < WOOD_TYPES.length; ++i) {
            this.icons[i] = par1IconRegister.registerIcon("violetcraft:sapling_" + WOOD_TYPES[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        if (p_149691_2_ >= WOOD_TYPES.length) {
            p_149691_2_ = 0;
        }
        return icons[p_149691_2_];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        for (int i = 0; i < icons.length; ++i) {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }
}