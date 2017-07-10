package violetcraft;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import violetcraft.registry.ItemRegistry;

@Mod(modid = "ttr_smelt")
public class Smelt {
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

        GameRegistry.addSmelting(VioletCraftMod.BlockVirenOre,new ItemStack(ItemRegistry.VirenIngot),0.1f);

        GameRegistry.registerFuelHandler(new IFuelHandler(){
            @Override
            public int getBurnTime(ItemStack fuel){
                if(fuel.getItem().equals(Items.apple)){
                    return 200;
                }
                return 0;
            }
        });
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }
}