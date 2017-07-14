package violetcraft.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import violetcraft.entity.model.ModelMoonRabbit;


public class RenderMoonRabbit extends RenderLiving
{

    public RenderMoonRabbit() {
        super(new ModelMoonRabbit() , 0.3F);
    }

    /**テクスチャを登録するメソッド*/
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation("violetcraft:textures/mobs/moonrabbit.png");
    }

}
