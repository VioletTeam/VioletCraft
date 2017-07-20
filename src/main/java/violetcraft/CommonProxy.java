package violetcraft;


import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import violetcraft.plugin.tc.ModAspect;
import violetcraft.plugin.tc.VioletMagic;
import violetcraft.registry.ItemRegistry;

public class CommonProxy {
    public void registerRender() {

    }
    public void registerClientInfo(){}

    public void postInit(FMLPostInitializationEvent event) {
            if(VioletCraftMod.thaumcraftLoaded) {
                ModAspect.Init();
                VioletMagic.Init();
                ItemRegistry.addcap();
            }

    }
}

