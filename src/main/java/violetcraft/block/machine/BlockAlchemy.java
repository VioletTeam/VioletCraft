package violetcraft.block.machine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import violetcraft.VioletCraftMod;
import violetcraft.registry.BlockRegistry;
import violetcraft.tile.TileAlchemy;


public class BlockAlchemy extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon field_149935_N;
    @SideOnly(Side.CLIENT)
    private IIcon field_149936_O;
    public BlockAlchemy(){
        super(Material.rock);
        this.setCreativeTab(VioletCraftMod.tabVioletCraft);
        this.setBlockName("alchemy");
        this.setBlockTextureName("violetcraft:alchemy");
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setHarvestLevel("pickaxe", 3);
        this.setLightLevel(0);
    }

    public static void updateFurnaceBlockState(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_) {
        int l = p_149931_1_.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
        TileEntity tileentity = p_149931_1_.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
        if (p_149931_0_) {
            p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, BlockRegistry.AlchemyMachine);
        } else {
            p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, BlockRegistry.AlchemyMachine);
        }
        p_149931_1_.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);

        if (tileentity != null) {
            tileentity.validate();
            p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        TileAlchemy tilealchemy = (TileAlchemy) world.getTileEntity(x, y, z);

        if (tilealchemy != null)
        {
            player.openGui(VioletCraftMod.INSTANCE, VioletCraftMod.GUI_Alchemy, world, x, y, z);
        }

        return true;
//		}
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileAlchemy();
    }

    //ブロックが壊れた時の処理
    //周辺に中に入っていたアイテムをまき散らす
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        TileAlchemy tileentity = (TileAlchemy) par1World.getTileEntity(par2, par3, par4);

        if (tileentity != null)
        {
            for (int j1 = 0; j1 < tileentity.getSizeInventory(); ++j1)
            {
                ItemStack itemstack = tileentity.getStackInSlot(j1);

                if (itemstack != null)
                {
                    float f = par1World.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = par1World.rand.nextFloat() * 0.8F + 0.1F;
                    float f2 = par1World.rand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0)
                    {
                        int k1 = par1World.rand.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize)
                        {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        EntityItem entityitem = new EntityItem(par1World, par2 + f, par3 + f1, par4 + f2,
                                new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem()
                                    .setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }

                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)par1World.rand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)par1World.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)par1World.rand.nextGaussian() * f3);
                        par1World.spawnEntityInWorld(entityitem);
                    }
                }
            }

            par1World.func_147453_f(par2, par3, par4, par5);
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_149935_N : (p_149691_1_ == 0 ? this.field_149935_N : (p_149691_1_ == 2 ? this.blockIcon:this.field_149936_O));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("violetcraft:alchemy_top");
        this.field_149936_O = p_149651_1_.registerIcon("violetcraft:alchemy_side");
        this.field_149935_N = p_149651_1_.registerIcon("violetcraft:alchemy_side");
    }
}
