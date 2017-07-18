package thaumcraft.api.wands;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.AspectList;


public interface IWandFocus {

    /**
     * @return The color the focus should be changed to.
     */
    int getFocusColor();

    /**
     * @return An icon that will be drawn as a block inside the focus "block".
     */
    IIcon getFocusDepthLayerIcon();

    IIcon getOrnament();

    WandFocusAnimation getAnimation();

    /**
     * Gets the amount of vis used per aspect per click or tick. This cost is actually listed as
     * a hundredth of a single point of vis, so a cost of 100 will equal one vis per tick/click.
     * It is returned as an AspectList to allow for multiple vis types in different ratios.
     */
    AspectList getVisCost();

    boolean isVisCostPerTick();

    ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition);

    void onUsingFocusTick(ItemStack itemstack, EntityPlayer player, int count);

    void onPlayerStoppedUsingFocus(ItemStack itemstack, World world, EntityPlayer player, int count);

    /**
     * Helper method to determine in what order foci should be iterated through when
     * the user presses the 'change focus' keybinding.
     *
     * @return a string of characters that foci will be sorted against.
     * For example AA00 will be placed before FG12
     * <br>As a guide build the sort string from two alphanumeric characters followed by
     * two numeric characters based on... whatever.
     */
    String getSortingHelper(ItemStack itemstack);

    boolean onFocusBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player);

    boolean acceptsEnchant(int id);

    enum WandFocusAnimation {
        WAVE, CHARGE
    }


}
