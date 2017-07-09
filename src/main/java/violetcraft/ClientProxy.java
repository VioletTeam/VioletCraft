package violetcraft;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import violetcraft.entity.EntityMoonRabbit;
import violetcraft.entity.render.RenderMoonRabbit;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy{

    public void registerRender(){
        RenderingRegistry.registerEntityRenderingHandler(EntityMoonRabbit.class, new RenderMoonRabbit());
    }


}