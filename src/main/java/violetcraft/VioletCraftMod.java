package violetcraft;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import violetcraft.entity.VioletEntity;
import violetcraft.gui.GuiBlock;
import violetcraft.gui.GuiHandler;
import violetcraft.registry.BlockRegistry;
import violetcraft.registry.ItemsRegistry;
import violetcraft.registry.MachineRegistry;
import violetcraft.registry.TileEntityRegistry;

@Mod(modid = "VioletCraftMod",
        name = "Violet Craft",
        version = "0.1.0.0")

public class VioletCraftMod {
    @SidedProxy(clientSide = "violetcraft.ClientProxy", serverSide = "violetcraft.ServerProxy")
    public static CommonProxy proxy;
    @Mod.Instance("VioletCraftMod")
    public static VioletCraftMod INSTANCE;

    public static Block BlockVirenOre;

    public static final int GUI_ID = 0;
    public static Block GuiBlock;

    /***
     * Configファイル読み込みと出力
     * アイテム　ブロックの登録
     * @param event
     */

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
        try {
            cfg.load();
            /*
			 * Configの項目の生成と読み込み。
			 * この段階では、まだ項目はありません。
			 */
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cfg.save();
        }

        BlockRegistry.blockRegistry();
        ItemsRegistry.registry();
        MachineRegistry.registry();
        Recipes.registry();
    }

    /***
     * レシピの追加
     * 各種データ設定
     * @param event
     */
    @EventHandler
    public void preInit(FMLPostInitializationEvent event) {
        GuiBlock = new GuiBlock()
                .setBlockTextureName("violetcraft:Gui_Block")
                .setBlockName("GuiBlock")
                .setCreativeTab(VioletCraftMod.VioletCradtMod);
        GameRegistry.registerBlock(GuiBlock, "GuiBlock");
        VioletEntity.register(this);

        GameRegistry.registerWorldGenerator(new OreGenerator(), 0);

        TileEntityRegistry.registry();

    }

    /***
     * その他
     * 他のMod連携など
     * @param event
     */
    @EventHandler
    public void init(FMLInitializationEvent event) {
        VioletEntity.register(this);
        VioletEntity.addSpawns();
        proxy.registerRender();

        NetworkRegistry.INSTANCE.registerGuiHandler(this.INSTANCE, new GuiHandler());
	    /*EntityのRenderを登録する
	     *Client側でのみ登録するため、今回はif文で処理をする。*/
    }


    /***
     * クリエイティブタブアイコン
     */
    public static CreativeTabs VioletCradtMod
            = new CreativeTabs("violettab") {
        public Item getTabIconItem() {
            return ItemsRegistry.VirenIngot;
        }
    };
}
