package violetcraft.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeRegistry {

	/**
	 * レシピ登録
	 */
	public static void registerRecipes()
	{
		GameRegistry.addRecipe ( new ItemStack(ItemRegistry.VirenSword, 1),
			"xxx", "xxx", "xxx",
			'x', BlockRegistry.BlockVirenBlock);
		GameRegistry.addRecipe ( new ItemStack(ItemRegistry.VirenSword, 1),
			" x ", " x ", " y ",
			'x', ItemRegistry.VirenIngot,
			'y', Items.stick);
		GameRegistry.addRecipe ( new ItemStack(ItemRegistry.yukariParker),
			"wbw", "blb", "wpw",
			'b', new ItemStack(Items.dye,1,0),
			'p', new ItemStack(Items.dye,1,9),
			'l', Items.leather_chestplate,
			'w', Blocks.wool);
	}
}
