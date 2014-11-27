package net.minecraft.vombat.world;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.vombat.VombatMod;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 * Adds the custom blocks we've created to world generation.
 *
 * Created by russt on 11/24/14.
 */
public class VombatBlockGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int x, int z, World world, IChunkProvider iChunkProvider, IChunkProvider iChunkProvider1) {
        if(world.provider.getDimensionId() == 0) { // Only spawn in the normal world.
            generateMarble(world, random, x * 16, z * 16);
        }
    }

    public void generateMarble(World world, Random random, int x, int z) {
        addBlockSpawn(VombatMod.marbleBlock.getDefaultState(), world, random, x ,z, 16, 16, 16, 15, 50);
    }

    public void addBlockSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos,
                              int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int maxY) {
        for (int i = 0; i < chancesToSpawn; i++) {
            int firstBlockXCoord = blockXPos + random.nextInt(maxX);
            int firstBlockYCoord = random.nextInt(maxY);
            int firstBlockZCoord = blockZPos + random.nextInt(maxZ);
            BlockPos position = new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
            new WorldGenMinable(block, maxVeinSize).generate(world, random, position);
        }
    }
}
