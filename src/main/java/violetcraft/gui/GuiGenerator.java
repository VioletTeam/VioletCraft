package violetcraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import violetcraft.tile.TileGenerator;


public class GuiGenerator extends GuiContainer
{
	private static final ResourceLocation TEXTURE = new ResourceLocation("violetcraft:textures/gui/gui_generator.png");
	private TileGenerator tileGenerator;

	public GuiGenerator(EntityPlayer player, TileGenerator tileentity) {
		super(new ContainerGenerator(player, tileentity));
		this.tileGenerator = tileentity;
	}

    /*GUIの文字等の描画処理*/
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseZ) {
    	fontRendererObj.drawString("GuiGenerator", 58, 6, 0x404040);
    	fontRendererObj.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
		if (this.tileGenerator.isBurning()) {
			int i1 = this.tileGenerator.getBurnTimeRemainingScaled(60) / 200;
			String Sta = String.valueOf(i1);
			fontRendererObj.drawString(Sta ,8 ,40 , 424342);

			i1 = this.tileGenerator.getCookProgressScaled(60);
			String Sta1 = String.valueOf(i1);
			fontRendererObj.drawString(Sta1 ,80 ,30 , 424342);

			int ts = this.tileGenerator.generatorAmount;
			String Sta2 = String.valueOf(ts);
			fontRendererObj.drawString(Sta2 ,120 ,30 , 424342);
    	}
	}

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseZ) {

    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

    	// テクスチャの指定
    	this.mc.getTextureManager().bindTexture(TEXTURE);

        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.tileGenerator.isBurning()) {
			int i1 = this.tileGenerator.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
//            i1 = this.tileGenerator.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		}
    }

}
