package violetcraft;


import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import violetcraft.plugin.tc.ModAspect;

public class CommonProxy {
    public void registerRender() {

    }
    public void registerClientInfo(){}

    public void postInit(FMLPostInitializationEvent event) {
            if(VioletCraftMod.thaumcraftLoaded) {
                ModAspect.Init();
            }

    }
}

