package violetcraft.registry;

import static violetcraft.registry.BlockRegistry.VioletOakLog;
import static violetcraft.registry.BlockRegistry.VioletOakPlank;
import static violetcraft.registry.ItemRegistry.*;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipeRegistry {

	public static void addRecipeRegistry() {
		//Add Recipes
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.VirenSword, 1),
				" x ", " x ", " y ", 'x',
				VirenIngot, 'y', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.YukariParker),
				"wbw", "blb", "wpw",
				'b', new ItemStack(Items.dye, 1, 0), 'p', new ItemStack(Items.dye, 1, 9), 'l', Items.leather_chestplate, 'w', Blocks.wool);
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.VirenBlock, 1),
				"xxx", "xxx", "xxx",
				'x', VirenIngot);
		GameRegistry.addRecipe(new ItemStack(ItemRegistry.VirenSword, 1),
				" x ", " x ", " y ",
				'x', VirenIngot, 'y', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.VioletOakPlank, 4),

				VioletOakLog);
		GameRegistry.addRecipe(new ItemStack(BlockRegistry.VioletPortal, 1),
				"beb","ete","beb",
				't',tear_eye,'b',Items.slime_ball,'e',Items.ender_pearl);

		//Add Smelting Recipes
		GameRegistry.addSmelting(BlockRegistry.VirenOre, new ItemStack(VirenIngot), 0.1f);
		GameRegistry.addSmelting(ItemRegistry.RawMoonMeat, new ItemStack(ItemRegistry.CookedMoonMeat), 0.15f);

		//Add Fuel Handler
		GameRegistry.registerFuelHandler(fuel -> {
			Item item = fuel.getItem();
			if (item == Items.apple) {
				return 200;
			} else {
				return 0;
			}
		});
		//oreDictionary
		OreDictionary.registerOre("logWood",VioletOakLog);
		OreDictionary.registerOre("plankWood",VioletOakPlank);
	}
}
