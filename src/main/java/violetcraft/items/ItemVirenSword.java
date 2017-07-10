package violetcraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.VioletCraftRegistry;

import java.util.List;

public class ItemVirenSword extends ItemSword {
    //ToDo
    public static Item toolconf;

    public static ToolMaterial TOOLCONF
            = EnumHelper.addToolMaterial("TOOLCONF", 3, 50, 8F, 10F, 10)
            .setRepairItem(new ItemStack(toolconf));

    public ItemVirenSword() {
        super(TOOLCONF);
        this.setCreativeTab(VioletCraftRegistry.VioletCraftMod);
        this.setUnlocalizedName("vc.virenSword");
        maxStackSize = 1;
        this.setTextureName("violetcraft:viren_sword");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {

    }
}