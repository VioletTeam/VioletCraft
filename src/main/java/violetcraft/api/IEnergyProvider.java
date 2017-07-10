package violetcraft.api;


import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergyProvider extends IEnergyConnection {

    /**
     * Remove energy from an IEnergyProvider, internal distribution is left entirely to the IEnergyProvider.
     *
     * @param from
     *            Orientation the energy is extracted from.
     * @param maxExtract
     *            Maximum amount of energy to extract.
     * @param simulate
     *            If TRUE, the extraction will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted.
     */
    int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate);

    /**
     * Returns the amount of energy currently stored.
     */
    int getEnergyStored(ForgeDirection from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    int getMaxEnergyStored(ForgeDirection from);

}