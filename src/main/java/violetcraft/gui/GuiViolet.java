package violetcraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import violetcraft.tiles.TileEntityGuiBlock;

public class GuiViolet extends GuiContainer
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("violetcraft:textures/gui/yukari_gui.png");
	private TileEntityGuiBlock tileEntity;

	public GuiViolet(EntityPlayer player, TileEntityGuiBlock tileEnttiy) {
        super(new ContainerViolet(player, tileEnttiy));
        this.tileEntity = tileEnttiy;
		ySize = 222;
    }

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		fontRendererObj.drawString(StatCollector.translateToLocal(tileEntity.getInventoryName()), 8, 6, 4210752);
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

    /*GUIの背景の描画処理*/
	@Override
	protected void drawGuiContainerBackgroundLayer(float tick, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(TEXTURE);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}

//    @Override
//    protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseZ)
//    {
//        this.mc.renderEngine.bindTexture(TEXTURE);
//        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
//    }

    /*GUIが開いている時にゲームの処理を止めるかどうか。*/
//    @Override
//    public boolean doesGuiPauseGame() {
//        return false;
//    }
}