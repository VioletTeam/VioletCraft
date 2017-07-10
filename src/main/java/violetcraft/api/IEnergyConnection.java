package violetcraft.api;


import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyConnection {

    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    boolean canConnectEnergy(ForgeDirection from);

}