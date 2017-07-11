package violetcraft.api;

public class EnergyStorage implements IEnergyStorage{

	protected int energy;
	protected int capacity;
	protected int maxReceive;
	protected int maxExtract;

	/* IEnergyStorage */
	@Override
	public int inputEnergy(int maxInput, boolean has) {
		int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

		if (!has) {
			energy += energyReceived;
		}
		return energyReceived;
	}

	@Override
	public int outputEnergy(int maxOutput, boolean has) {
		int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

		if (!has) {
			energy -= energyExtracted;
		}
		return energyExtracted;
	}

	@Override
	public int getEnergyStored() {
		return energy;
	}

	@Override
	public int getMaxEnergyStored() {
		return capacity;
	}
}
