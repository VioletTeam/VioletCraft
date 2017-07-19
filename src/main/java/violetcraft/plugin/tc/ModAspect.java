package violetcraft.plugin.tc;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import violetcraft.registry.BlockRegistry;
import violetcraft.registry.ItemRegistry;

public class ModAspect {
    public static Aspect VIOLET;
    public static String ResearchViolet = "Violet";

    public static void Init() {
        initAspect();
        registerAspect();

        ResearchCategories.registerCategory(ResearchViolet, new ResourceLocation("violetcraft", "textures/items/magicpaper.png"), new ResourceLocation("tofufactory", "textures/gui/guiTofuKinu.png"));

    }

    private static void initAspect() {
        VIOLET = new Aspect("violet", 16711935,
                new Aspect[]{Aspect.MAGIC, Aspect.LIGHT},
                new ResourceLocation("violetcraft", "textures/aspects/violet.png"), 1);
    }

    private static void registerAspect() {
        //book
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.violetbook, 1, 0), (new AspectList()).add(VIOLET, 12).add(Aspect.SENSES, 6));
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.Magicpaper, 1, 0), (new AspectList()).add(VIOLET, 6).add(Aspect.SENSES, 2));
        //rabbit
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.RabbitTear, 1, 0), (new AspectList()).add(VIOLET, 4).add(Aspect.WATER, 3));
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.RabbitEgg, 1, 0), (new AspectList()).add(VIOLET, 3).add(Aspect.LIFE, 6).add(Aspect.AURA, 2));
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.RawMoonMeat, 1, 0), (new AspectList()).add(Aspect.HUNGER, 4).add(Aspect.FLESH, 3).add(VIOLET, 2));
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.CookedMoonMeat, 1, 0), (new AspectList()).add(Aspect.HUNGER, 6).add(Aspect.FLESH, 3).add(VIOLET, 2));
        //viren
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.VirenIngot, 1, 0), (new AspectList()).add(VIOLET, 4).add(Aspect.METAL, 3).add(Aspect.AURA, 4));
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VirenBlock, 1, 0), (new AspectList()).add(VIOLET, 10).add(Aspect.METAL, 12).add(Aspect.AURA, 8));
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.ItemVirenScythe, 1, 0), (new AspectList()).add(VIOLET, 8).add(Aspect.DEATH, 6).add(Aspect.WEAPON, 12));
        ThaumcraftApi.registerObjectTag(new ItemStack(ItemRegistry.VirenSword, 1, 0), (new AspectList()).add(VIOLET, 6).add(Aspect.WEAPON, 10));
        //mob
        ThaumcraftApi.registerEntityTag("MoonRabbit",(new AspectList()).add(VIOLET,4).add(Aspect.AURA,2).add(Aspect.BEAST,3));
        //dimension
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VioletGrassBlock, 1, 0), (new AspectList()).add(VIOLET, 3).add(Aspect.EARTH, 3));
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VioletDift, 1, 0), (new AspectList()).add(VIOLET, 3).add(Aspect.EARTH, 3).add(Aspect.PLANT, 3));
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VioletOakPlank, 1, 0), (new AspectList()).add(VIOLET, 3).add(Aspect.TREE, 4));
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VioletOakPlank, 1, 0), (new AspectList()).add(VIOLET, 5).add(Aspect.TREE, 6));
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VioletLeave, 1, 0), (new AspectList()).add(VIOLET, 1).add(Aspect.PLANT, 3));
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VioletSapling, 1, 0), (new AspectList()).add(VIOLET, 2).add(Aspect.PLANT, 2));
        ThaumcraftApi.registerObjectTag(new ItemStack(BlockRegistry.VioletGrass, 1, 0), (new AspectList()).add(VIOLET, 1).add(Aspect.PLANT, 2));
    }


}