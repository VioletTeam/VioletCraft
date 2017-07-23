package violetcraft.registry;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AlchemyRecipes
{
    private static final AlchemyRecipes smeltingBase = new AlchemyRecipes();
    /** The list of smelting results. */
    private Map<ItemStack, ItemStack> smeltingList = new HashMap<ItemStack, ItemStack>();
    private Map<ItemStack, Float> experienceList = new HashMap<>();
    private static final String __OBFID = "CL_00000085";

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static AlchemyRecipes smelting()
    {
        return smeltingBase;
    }
    //錬金術のレシピ
    private AlchemyRecipes()
    {
        this.blockAlchemy(Blocks.log, new ItemStack(BlockRegistry.VioletOakLog), 0.1F);
        this.blockAlchemy(Blocks.log2, new ItemStack(BlockRegistry.VioletOakLog), 0.1F);
        this.blockAlchemy(Blocks.sapling, new ItemStack(BlockRegistry.VioletSapling), 0.1F);
        this.itemAlchemy(Items.paper, new ItemStack(ItemRegistry.Magicpaper), 0.05F);


        this.blockAlchemy(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
        this.blockAlchemy(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
        this.blockAlchemy(Blocks.lapis_ore, new ItemStack(Items.dye, 1, 4), 0.2F);
        this.blockAlchemy(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);
    }

    public void blockAlchemy(Block block, ItemStack itemStack, float p_151393_3_)
    {
        this.itemAlchemy(Item.getItemFromBlock(block), itemStack, p_151393_3_);
    }

    public void itemAlchemy(Item item, ItemStack itemstack, float p_151396_3_)
    {
        this.func_151394_a(new ItemStack(item, 1, 32767), itemstack, p_151396_3_);
    }

    public void func_151394_a(ItemStack itemstack, ItemStack itemStack, float p_151394_3_)
    {
        this.smeltingList.put(itemstack, itemStack);
        this.experienceList.put(itemStack, p_151394_3_);
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator<Map.Entry<ItemStack, ItemStack>> iterator = this.smeltingList.entrySet().iterator();
        Map.Entry<ItemStack, ItemStack> entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = iterator.next();
        }
        while (!this.getItem(p_151395_1_, entry.getKey()));

        return entry.getValue();
    }

    private boolean getItem(ItemStack itemStack2, ItemStack itemStack3)
    {
        return itemStack3.getItem() == itemStack2.getItem() && (itemStack3.getItemDamage() == 32767 || itemStack3.getItemDamage() == itemStack2.getItemDamage());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack itemStack)
    {
        float ret = itemStack.getItem().getSmeltingExperience(itemStack);
        if (ret != -1) return ret;

        Iterator<Map.Entry<ItemStack, Float>> iterator = this.experienceList.entrySet().iterator();
        Map.Entry<ItemStack, Float> entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = iterator.next();
        }
        while (!this.getItem(itemStack, entry.getKey()));

        return (entry.getValue()).floatValue();
    }
}