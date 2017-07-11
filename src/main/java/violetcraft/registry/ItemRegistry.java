package violetcraft.registry;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.block.*;
import violetcraft.item.*;

public class ItemRegistry {
    public static ItemArmor.ArmorMaterial Parker = EnumHelper.addArmorMaterial("YUKARIParker", 8, new int[]{3, 5, 6, 3}, 30);
    /***
     * Ore
     */
    public static Block RollYellowOre;
    public static Block ScarRedOre;
    public static Block blueTopazOre;
    public static Block PinkSapphireOre;
    public static Block BlockVirenOre;
    public static Block dimensionportal;
    public static Block violetdift;
    public static Block violetgrass;
    public static Block violettallgrass;



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
    public static Item moonmeat_cooked;
    public static Item moonmeat_raw;
    public static Item moonrabbit_tear;
    public static Item rabbitegg;
    /***
     * YukariParker
     */
    public static Item yukariParker;

    public static String string;

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
        moonrabbit_tear = new ItemMoonRabbitTear();
        moonmeat_cooked= new ItemCookedMoonRabbit(5,6,true);
        moonmeat_raw= new ItemRawMoonRabbit(3,1,true);

        dimensionportal = new BlockVioletPortal(Material.portal ,string);
        violetdift = new VioletDift();
        violetgrass = new BlockVioletGrass();
        violettallgrass = new VioletGrass();

    }
}
