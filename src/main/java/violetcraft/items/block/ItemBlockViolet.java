package violetcraft.items.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockViolet extends ItemBlock
{
	protected final Block block;
	public ItemBlockViolet(Block block)
	{
		super(block);
		this.block = block;
	}
}
