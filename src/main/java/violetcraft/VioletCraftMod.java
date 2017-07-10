package violetcraft;


import com.google.common.collect.Lists;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
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
import violetcraft.gui.GuiHandler;
import violetcraft.registry.BlockRegistry;
import violetcraft.registry.ItemsRegistry;
import violetcraft.registry.MachineRegistry;
import violetcraft.registry.TileEntityRegistry;

@Mod(modid = VioletCraftMod.MOD_ID, name = VioletCraftMod.MOD_NAME, version = VioletCraftMod.VERSION, useMetadata = true)
public class VioletCraftMod {
    //Mod Info
    public static final String MOD_ID = "violetcraftmod";
    public static final String MOD_NAME = "ViolentCraft";
    public static final String VERSION = "0.1.0.0";
    public static final int GUI_ID = 0;
    @SidedProxy(clientSide = "violetcraft.ClientProxy", serverSide = "violetcraft.ServerProxy")
    public static CommonProxy proxy;
    @Mod.Instance(MOD_ID)
    public static VioletCraftMod INSTANCE;
    @Mod.Metadata
    public static ModMetadata metadata;
    public static Block BlockVirenOre;
    public static Block GuiBlock;

    /***
     * クリエイティブタブ
     */
    public static CreativeTabs VioletCraftMod
            = new CreativeTabs("violet_craft") {
        public Item getTabIconItem() {
            return ItemsRegistry.VirenIngot;
        }
    };

    /***
     * Configファイル読み込みと出力
     * アイテム　ブロックの登録
     * @param event please see cpw.mods.fml.common.event.FMLPreInitializationEvent
     */

    @EventHandler
    @SuppressWarnings("unused")
    public void preInit(FMLPreInitializationEvent event) {
        loadMeta();
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
    }

    /***
     * レシピの追加
     * 各種データ設定
     * @param event please see cpw.mods.fml.common.event.FMLInitializationEvent
     */
    @EventHandler
    @SuppressWarnings("unused")
    public void init(FMLInitializationEvent event) {
        VioletEntity.register(this);
        GameRegistry.registerWorldGenerator(new OreGenerator(), 0);
        TileEntityRegistry.registry();
        Recipes.registry();
    }

    /***
     * その他
     * 他のMod連携など
     * @param event please see cpw.mods.fml.common.event.FMLPostInitializationEvent
     */
    @EventHandler
    @SuppressWarnings("unused")
    public void postInit(FMLPostInitializationEvent event) {
        VioletEntity.register(this);
        VioletEntity.addSpawns();
        proxy.registerRender();

        NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, new GuiHandler());
        /*EntityのRenderを登録する
         *Client側でのみ登録するため、今回はif文で処理をする。*/
    }

    private void loadMeta() {
        if (metadata == null) {
            throw new IllegalStateException("ModMetadata is not initialized");
        }
        metadata.autogenerated = false;
        metadata.modId = MOD_ID;
        metadata.name = MOD_NAME;
        metadata.version = VERSION;
        metadata.authorList = Lists.newArrayList("keikun4649", "pentan", "c6h2cl2");
        metadata.description = "Violet Craft mods.";
        metadata.credits = "Created by Hrose Kei";
        metadata.logoFile = "assets/violetcraft/violet_logo.png";
    }
}
