package violetcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import violetcraft.VioletCraftMod;
import violetcraft.registry.MachineRegistry;
import violetcraft.tiles.TileEntityGenerator;

public class BlockGenerator extends BlockContainer
{

	private static boolean field_149934_M;

	public BlockGenerator()
	{
		super(Material.rock);
		this.setCreativeTab(VioletCraftMod.VioletCraftMod);
		this.setBlockName("VC.BlockGenerator");
	    this.setBlockTextureName("violetcraft:Block_Generator");
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(0);

		GameRegistry.registerBlock(this, "BlockGenerator");
	}

	public static void updateFurnaceBlockState(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_) {
		int l = p_149931_1_.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
		TileEntity tileentity = p_149931_1_.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
		field_149934_M = true;

		if (p_149931_0_) {
			p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, MachineRegistry.TestMachine);
		} else {
			p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, MachineRegistry.TestMachine);
		}

		field_149934_M = false;
		p_149931_1_.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);

		if (tileentity != null) {
			tileentity.validate();
			p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
//		if (world.isRemote) {
//			return true;
//		} else {
			// GUIを開く。
			TileEntityGenerator TileEntityGenerator = (TileEntityGenerator)world.getTileEntity(x, y, z);

            if (TileEntityGenerator != null)
            {
            	player.openGui(VioletCraftMod.INSTANCE, 1, world, x, y, z);
            }

			return true;
//		}
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityGenerator();
	}

	//ブロックが壊れた時の処理
	//周辺に中に入っていたアイテムをまき散らす
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		TileEntityGenerator tileentity = (TileEntityGenerator) par1World.getTileEntity(par2, par3, par4);

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
}
