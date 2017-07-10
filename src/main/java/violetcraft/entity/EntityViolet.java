package violetcraft.entity;


import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import violetcraft.VioletCraft;

public class EntityViolet {
    public static void register(VioletCraft violetCraft) {
        EntityRegistry.registerModEntity(EntityMoonRabbit.class, "MoonRabbit", 0, violetCraft, 30, 1, false);
    }
    public static void addSpawns() {
        EntityRegistry.addSpawn(EntityMoonRabbit.class, 5, 1, 4, EnumCreatureType.creature, BiomeGenBase.plains);
    }

}
