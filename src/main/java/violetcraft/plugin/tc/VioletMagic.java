package violetcraft.plugin.tc;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import violetcraft.VioletCraftMod;
import violetcraft.item.MoonRabbitTear;
import violetcraft.registry.ItemRegistry;


public class VioletMagic {
    public static ShapelessArcaneRecipe MagicPaper;
    public static void Init(){
        initrecipe();

    }



    public static void initrecipe() {
        ItemStack item =new ItemStack(ItemRegistry.wandCap,1,0);
        MagicPaper = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "MagicPaper",
                new ItemStack(ItemRegistry.Magicpaper, 1),
                new AspectList().add(Aspect.AIR, 8).add(Aspect.ORDER, 8).add(Aspect.FIRE, 8).add(Aspect.EARTH, 8).add(Aspect.ENTROPY, 8).add(Aspect.WATER, 8),
                new ItemStack(Items.paper, 1));
        InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe("VirenCap",item
                ,1
                ,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WEAPON, 8).add(Aspect.ENERGY, 8),
                new ItemStack(ItemRegistry.wandCap, 1,0),
                new ItemStack[]{
                        new ItemStack(ItemRegistry.RabbitTear, 1, 0)
                        , new ItemStack(ItemRegistry.RabbitTear, 1, 0)
        });


        new ResearchItem("MagicPaper", "Violet",
                new AspectList().add(Aspect.SENSES, 5).add(ModAspect.VIOLET, 5),
                0, -4, 0,new ResourceLocation("violetcraft","textures/items/magicpaper.png"))
                .setPages(new ResearchPage("tc.research_page.VioletPaper"))
                .registerResearchItem();
        new ResearchItem("VirenCap", "Violet",
                new AspectList().add(ModAspect.VIOLET, 6).add(Aspect.TOOL, 6).add(Aspect.ENERGY, 4),
                2, -4, 1,new ResourceLocation("violetcraft","textures/items/wand_cap_viren.png"))
                .setPages(new ResearchPage("tc.research_page.VioletCap"))
                .registerResearchItem();
    }
}

