package violetcraft.registry;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.block.BlockBlueTopazOre;
import violetcraft.block.BlockPinkSapphireOre;
import violetcraft.block.BlockRollYellowOre;
import violetcraft.block.BlockScarRedOre;
import violetcraft.block.BlockVirenOre;
import violetcraft.item.ItemCookedMoonRabbit;
import violetcraft.item.ItemMoonRabbitTear;
import violetcraft.item.ItemRabbitegg;
import violetcraft.item.ItemRawMoonRabbit;
import violetcraft.item.ItemVirenIngot;
import violetcraft.item.ItemVirenScythe;
import violetcraft.item.ItemVirenSword;
import violetcraft.item.ItemYukariParker;

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
	public static Item ItemVirenScythe;
    public static Item test;
    public static Item moonmeat_cooked;
    public static Item moonmeat_raw;
    public static Item moonrabbit_tear;
    public static Item rabbitegg;

    /***
     * YukariParker
     */
    public static Item yukariParker;

    public static void registry() {
        VirenIngot = new ItemVirenIngot();

        VirenSword = new ItemVirenSword();
        GameRegistry.registerItem(new ItemVirenScythe(Item.ToolMaterial.EMERALD), "viren_scythe");

        RollYellowOre = new BlockRollYellowOre();
        ScarRedOre = new BlockScarRedOre();
        blueTopazOre = new BlockBlueTopazOre();
        PinkSapphireOre = new BlockPinkSapphireOre();
        BlockVirenOre = new BlockVirenOre();
        yukariParker = new ItemYukariParker(Parker, 0, 1);

        rabbitegg = new ItemRabbitegg();
        moonmeat_cooked= new ItemCookedMoonRabbit(5,6,true);
        moonmeat_raw= new ItemRawMoonRabbit(3,1,true);
        GameRegistry.registerItem(new ItemMoonRabbitTear(),"moonrabbit_tear");
    }
}
