package violetcraft.items;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class Tool extends ItemTool
{
	private static final Set canHarvestBlock = Sets.newHashSet(new Block[] { Blocks.diamond_block });

	public Tool(ToolMaterial toolMaterial) {
		super(0.0F, toolMaterial, canHarvestBlock);
	}

	@Override
	public boolean func_150897_b(Block block) {
		return true;
	}

	@Override
	public float func_150893_a(ItemStack itemStack, Block block) {
		if (block.getMaterial() == Material.rock) {
			return this.efficiencyOnProperMaterial;
		}
		return super.func_150893_a(itemStack, block);
	}
}
