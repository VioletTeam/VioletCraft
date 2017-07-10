package violetcraft.items.machine;

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
import violetcraft.tiles.TilEntityeTestMachine;

public class TestMachine extends BlockContainer
{

	private static boolean field_149934_M;

	public TestMachine()
	{
		super(Material.rock);
		this.setCreativeTab(VioletCraftMod.VioletCraftMod);
		this.setBlockName("TestMachine");
	    this.setBlockTextureName("violetcraft:TestMachine");
		this.setHardness(1.0F);
		this.setResistance(10.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setLightLevel(0);

		GameRegistry.registerBlock(this, "TestMachine");
	}

	public static void updateFurnaceBlockState(boolean p_149931_0_, World p_149931_1_, int p_149931_2_, int p_149931_3_, int p_149931_4_)
    {
        int l = p_149931_1_.getBlockMetadata(p_149931_2_, p_149931_3_, p_149931_4_);
        TileEntity tileentity = p_149931_1_.getTileEntity(p_149931_2_, p_149931_3_, p_149931_4_);
        field_149934_M = true;

        if (p_149931_0_)
        {
        	p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, MachineRegistry.TestMachine);
        }
        else
        {
            p_149931_1_.setBlock(p_149931_2_, p_149931_3_, p_149931_4_, MachineRegistry.TestMachine);
        }

        field_149934_M = false;
        p_149931_1_.setBlockMetadataWithNotify(p_149931_2_, p_149931_3_, p_149931_4_, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            p_149931_1_.setTileEntity(p_149931_2_, p_149931_3_, p_149931_4_, tileentity);
        }
    }

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TilEntityeTestMachine();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		} else {
			// GUIを開く。
			TilEntityeTestMachine tileenTityTestMachine = (TilEntityeTestMachine) world.getTileEntity(x, y, z);

			if (tileenTityTestMachine != null) {
				player.openGui(VioletCraftMod.INSTANCE, 0, world, x, y, z);
//            	player.func_146100_a(tileenTityTestMachine);
			}

//			player.openGui(VioletCraftMod.INSTANCE, 0, world, x, y, z);
			return true;
		}
	}

	//ブロックが壊れた時の処理
	//周辺に中に入っていたアイテムをまき散らす
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		TilEntityeTestMachine tileentity = (TilEntityeTestMachine) par1World.getTileEntity(par2, par3, par4);

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
