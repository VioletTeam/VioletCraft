package violetcraft.world.biome.tree;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import violetcraft.registry.BlockRegistry;


public class WorldGenVioletTrees extends WorldGenVioletTreesBase {
    public WorldGenVioletTrees(boolean par1) {
        super(par1, 4, BlockRegistry.VioletOakLog, 0, BlockRegistry.VioletLeave, 2, false);
    }

    @Override
    public boolean isSoil(Block block, World world, int x, int y, int z) {
        return block == BlockRegistry.VioletGrassBlock
                || block == BlockRegistry.VioletDift;
    }

    @Override
    protected void putLeaves(int ox, int oy, int oz, int height, World par1World, Random par2Random) {
        byte zero = 0;
        int var9 = 3;
        int leavesY, blocksHighFromTop, radius, leavesX, relX;
        for (leavesY = oy - var9 + height; leavesY <= oy + height; ++leavesY) {
            blocksHighFromTop = leavesY - (oy + height);
            radius = height / 3;

            for (leavesX = ox - radius; leavesX <= ox + radius; ++leavesX) {
                relX = leavesX - ox;

                for (int leavesZ = oz - radius; leavesZ <= oz + radius; ++leavesZ) {
                    int relZ = leavesZ - oz;

                    Block block = par1World.getBlock(leavesX, leavesY, leavesZ);

                    if (block == null || block.canBeReplacedByLeaves(par1World, leavesX, leavesY, leavesZ)) {
                        int metadata;
                        if (fruitChance > 0 && par2Random.nextInt(fruitChance) == 0) {
                            metadata = this.metaFruit;
                        } else {
                            metadata = this.metaLeaves;
                        }
                        this.setBlockAndNotifyAdequately(par1World, leavesX, leavesY, leavesZ, blockLeaves, metadata);
                    }
                }
            }
        }
    }

}