package violetcraft.entity;


import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import violetcraft.VioletCraftMod;

public class VioletEntity {
    public static void register(VioletCraftMod violetCraftMod) {
        EntityRegistry.registerModEntity(EntityMoonRabbit.class, "MoonRabbit", 0, violetCraftMod, 30, 1, false);
    }
    public static void addSpawns() {
        EntityRegistry.addSpawn(EntityMoonRabbit.class, 5, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);
    }

}
