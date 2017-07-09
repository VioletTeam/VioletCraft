package violetcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import violetcraft.items.VioletItem;

public class Recipes {
	public static void registry()
	{
		GameRegistry.addRecipe
		(
			new ItemStack(VioletItem.VirenSword, 1),
				" x ",
				" x ",
				" y ",
				'x', VioletItem.VirenIngot,
				'y', Items.stick);
		GameRegistry.addRecipe
				(
						new ItemStack(VioletItem.yukariParker),

						"wbw",
						"blb",
						"wpw",
						'b', new ItemStack(Items.dye,1,0),
						'p', new ItemStack(Items.dye,1,9),
						'l', Items.leather_chestplate,
						'w', Blocks.wool
				);
	}
}
