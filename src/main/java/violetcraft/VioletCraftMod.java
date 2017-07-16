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
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import violetcraft.generator.VioletCraftOreGenerator;
import violetcraft.gui.GuiHandler;
import violetcraft.registry.BlockRegistry;
import violetcraft.registry.ItemRegistry;
import violetcraft.registry.RecipeRegistry;
import violetcraft.registry.VioletEntity;
import violetcraft.world.WorldProviderViolet;
import violetcraft.world.biome.BiomeGenViolet;
import violetcraft.world.biome.BiomeGenVioletIce;

@Mod(modid = VioletCraftMod.MOD_ID, name = VioletCraftMod.MOD_NAME, version = VioletCraftMod.VERSION, useMetadata = true)
public final class VioletCraftMod {
    //Mod Info
    public static final String MOD_ID = "violetcraftmod";
    public static final String MOD_NAME = "ViolentCraft";
    public static final String VERSION = "0.1.0.0";
    //Gui IDs
    public static final int GUI_GENERATOR = 0;
    public static final int GUI_ID = 0;
    @SidedProxy(clientSide = "violetcraft.ClientProxy", serverSide = "violetcraft.ServerProxy")
    public static CommonProxy proxy;
    @Mod.Instance(MOD_ID)
    public static VioletCraftMod INSTANCE;
    @Mod.Metadata
    public static ModMetadata metadata;
    // 独自ディメンションのID
    public static int dimensionID = -90;
    public static int providerType = -61;

	/** 追加するクリエイティブタブ */
    public static final CreativeTabs tabVioletCraft = new CreativeTabs("violet_craft") {
        public Item getTabIconItem() {
            return ItemRegistry.VirenIngot;
        }
    };

    public static int biomevioletID = 80;
    public static int biomevioletID2 = 81;
    public static Block GuiBlock;
    BiomeIdManager idManager = new BiomeIdManager();

    /***
     * Configファイル読み込みと出力
     * アイテム　ブロックの登録
     * @param event please see cpw.mods.fml.common.event.FMLPreInitializationEvent
     */
    @EventHandler
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

        BlockRegistry.addBlockRegistry();
        ItemRegistry.addItemRegistry();
        RecipeRegistry.addRecipeRegistry();
        VioletEntity.register(this);
        VioletEntity.addSpawns();

        DimensionManager.registerProviderType(providerType, WorldProviderViolet.class, false);
        // 独自ディメンションを登録
        DimensionManager.registerDimension(dimensionID, providerType);
    }

    /***
     * レシピの追加
     * 各種データ設定
     *
     @param event see cpw.mods.fml.common.event.FMLInitializationEvent
     */
    @EventHandler
    public void init(FMLInitializationEvent event) {
        BiomeGenBase violetplain = (new BiomeGenViolet(biomevioletID))
                .setColor(0x00ff00).setBiomeName("Violetplean");
        BiomeGenBase violetice = (new BiomeGenVioletIce(biomevioletID2))
                .setColor(0x00ff00).setBiomeName("VioletIce");

        //　VioletCraft関連鉱石の生成
        GameRegistry.registerWorldGenerator(new VioletCraftOreGenerator(), 0);
    }

    /**
     * その他
     * 他のMod連携など
     * @param event please see cpw.mods.fml.common.event.FMLPostInitializationEvent
     */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
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
