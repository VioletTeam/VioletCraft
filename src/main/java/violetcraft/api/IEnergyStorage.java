package violetcraft.api;

/**
 * エネルギーの貯蔵
 *
 * @author hrose_kei
 *
 */
public interface IEnergyStorage {

	/**
	 * エネルギーの受け取り
	 *
	 * @param int maxInput 受け取れるエネルギーの最大
	 * @param boolean TRUEの場合にエネルギーが挿入される
	 * @return
	 */
	int inputEnergy(int maxInput, boolean has);

	/**
	 * エネルギーの取り除きまたは出力
	 *
	 * @param maxOutput
	 * @param has
	 * @return
	 */
	int outputEnergy(int maxOutput, boolean has);

	/**
	 * 現在のエネルギーの量を返す。
	 */
	int getEnergyStored();

	/**
	 * 保存可能なエネルギーを返す。
	 */
	int getMaxEnergyStored();

}
