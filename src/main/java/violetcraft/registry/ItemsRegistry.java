package violetcraft.registry;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.block.BlockVirenOre;
import violetcraft.items.Rabbitegg;
import violetcraft.items.VirenIngot;
import violetcraft.items.VirenSword;
import violetcraft.items.armor.YukariParker;
import violetcraft.items.block.ore.BlueTopazOre;
import violetcraft.items.block.ore.PinkSapphireOre;
import violetcraft.items.block.ore.RollYellowOre;
import violetcraft.items.block.ore.ScarRedOre;

public class ItemsRegistry {
    public static ItemArmor.ArmorMaterial Parker = EnumHelper.addArmorMaterial("YUKARIParker", 8, new int[]{3, 5, 6, 3}, 30);
    /***
     * Ore
     */
    public static Block RollYellowOre;
    public static Block ScarRedOre;
    public static Block blueTopazOre;
    public static Block PinkSapphireOre;
    public static Block BlockVirenOre;

    /***
     * Ingot
     */
    public static Item RollYellowIngot;
    public static Item ScarRedIngot;
    public static Item blueTopaz;
    public static Item PinkSapphire;
    public static Item VirenIngot;

    /***
     * Item
     */

    public static Item VirenSword;
    public static Item test;

    /***
     * YukariParker
     */
    public static Item yukariParker;
    /***
     * egg
     */
    public static Item rabbitegg;

    public static void registry() {
//		YellowIngot = new RollYellowIngot();
        VirenIngot = new VirenIngot();
        VirenSword = new VirenSword();

        RollYellowOre = new RollYellowOre();
        ScarRedOre = new ScarRedOre();
        blueTopazOre = new BlueTopazOre();
        PinkSapphireOre = new PinkSapphireOre();
        BlockVirenOre = new BlockVirenOre();
//		GameRegistry.registerBlock(new BlockVirenOre(), "BlockVirenOre");
//    	GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
//		test = new test();
        yukariParker = new YukariParker(Parker, 0, 1);

        rabbitegg = new Rabbitegg();
    }
}
