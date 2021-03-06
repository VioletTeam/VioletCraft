package violetcraft.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import violetcraft.VioletCraftMod;
import violetcraft.tile.TileAlchemy;
import violetcraft.tile.TileGenerator;
import violetcraft.tile.TileGuiBlock;

public class GuiHandler implements IGuiHandler
{
    /*サーバー側の処理*/
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	if (!world.blockExists(x, y, z))
			return null;

    	TileEntity tileentity = world.getTileEntity(x, y, z);
        if (tileentity instanceof TileGuiBlock) {
            return new ContainerViolet(player, (TileGuiBlock) tileentity);
        }
        if (ID == VioletCraftMod.GUI_GENERATOR) {
            return new ContainerGenerator(player, (TileGenerator) tileentity);
        }
        if(ID == VioletCraftMod.GUI_Alchemy){
            return new ContainerAlchemy(player, (TileAlchemy) tileentity);
        }
        return null;
    }

    /*クライアント側の処理*/
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
    	if(!world.blockExists(x, y, z))
    		return null;

    	TileEntity tileentity = world.getTileEntity(x, y, z);

        if (tileentity instanceof TileGuiBlock) {
            return new GuiViolet(player, (TileGuiBlock) tileentity);
        }

        if (ID == 1) {
            return new GuiGenerator(player, (TileGenerator) tileentity);
        }
        if (ID == 2){
            return new GuiAlchemy(player, (TileAlchemy) tileentity);
        }
    	return null;


    }
}
