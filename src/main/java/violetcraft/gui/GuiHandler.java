package violetcraft.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import violetcraft.tiles.TilEntityeTestMachine;
import violetcraft.tiles.TileEntityGenerator;
import violetcraft.tiles.TileEntityGuiBlock;

public class GuiHandler implements IGuiHandler
{
    /*サーバー側の処理*/
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	if (!world.blockExists(x, y, z))
			return null;

    	TileEntity tileentity = world.getTileEntity(x, y, z);
    	if(tileentity instanceof TilEntityeTestMachine) {
    		return new ContainerTestMachine(player, (TilEntityeTestMachine) tileentity);
    	}
		if (tileentity instanceof TileEntityGuiBlock) {
			return new ContainerViolet(player, (TileEntityGuiBlock) tileentity);
		}
        if (ID == 1) {
        	return new ContainerGenerator(player, (TileEntityGenerator) tileentity);
        }
//		if (tileentity instanceof TileEntityGenerator) {
//			return new ContainerGenerator(player, (TileEntityGenerator) tileentity);
//		}

        return null;
    }

    /*クライアント側の処理*/
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	if(!world.blockExists(x, y, z))
    		return null;

    	TileEntity tileentity = world.getTileEntity(x, y, z);
    	if(tileentity instanceof TilEntityeTestMachine) {
    		return new GuiTestMachine(player, (TilEntityeTestMachine) tileentity);
    	}

    	if (tileentity instanceof TileEntityGuiBlock) {
			return new GuiViolet(player, (TileEntityGuiBlock) tileentity);
		}

        if (ID == 1) {
        	return new GuiGenerator(player, (TileEntityGenerator) tileentity);
        }

//    	if (tileentity instanceof TileEntityGenerator) {
//    		return new GuiGenerator(player, (TileEntityGenerator) tileentity);
//    	}
    	return null;


    }
}
