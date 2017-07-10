package violetcraft.registry;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.block.BlockBlueTopazOre;
import violetcraft.block.BlockPinkSapphireOre;
import violetcraft.block.BlockRollYellowOre;
import violetcraft.block.BlockScarRedOre;
import violetcraft.block.BlockVirenOre;
import violetcraft.item.ItemRabbitegg;
import violetcraft.item.ItemVirenIngot;
import violetcraft.item.ItemVirenSword;
import violetcraft.item.ItemYukariParker;

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
        VirenIngot = new ItemVirenIngot();
        VirenSword = new ItemVirenSword();

        RollYellowOre = new BlockRollYellowOre();
        ScarRedOre = new BlockScarRedOre();
        blueTopazOre = new BlockBlueTopazOre();
        PinkSapphireOre = new BlockPinkSapphireOre();
        BlockVirenOre = new BlockVirenOre();
        yukariParker = new ItemYukariParker(Parker, 0, 1);

        rabbitegg = new ItemRabbitegg();
    }
}
