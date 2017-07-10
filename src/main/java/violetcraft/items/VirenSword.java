package violetcraft.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import violetcraft.VioletCraftMod;

import java.util.List;

public class VirenSword extends ItemSword
{
    public static Item toolconf;
	public static Item VirenSword;

    public static ToolMaterial TOOLCONF
	 = EnumHelper.addToolMaterial("TOOLCONF",3,50,8F,10F,10)
			.setRepairItem(new ItemStack(toolconf));

    public VirenSword()
    {
    	super(TOOLCONF);

		String name = "virensword";

        this.setCreativeTab(VioletCraftMod.VioletCraftMod);
        this.setUnlocalizedName(name);
	    maxStackSize = 1;
	    this.setTextureName( "violetcraft:viren_sword" );

	    GameRegistry.registerItem(this,name);

	    return;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced)
    {
        list.add("test text");
    }
}
