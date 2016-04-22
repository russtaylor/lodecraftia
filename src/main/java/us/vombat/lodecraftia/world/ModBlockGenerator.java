package us.vombat.lodecraftia.world;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import us.vombat.lodecraftia.block.BlockList;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * Adds the custom blocks we've created to world generation.
 *
 * Created by russt on 11/24/14.
 */
public class ModBlockGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int x, int z, World world, IChunkProvider iChunkProvider, IChunkProvider iChunkProvider1) {
        if(world.provider.getDimensionId() == 0) { // Only spawn in the normal world.
            //Overworld spawning should occur here.
            addBlockSpawn(BlockList.andesiteStone.getDefaultState(), world, random, x, z, 100, 33, 10);
            addBlockSpawn(BlockList.basaltStone.getDefaultState(), world, random, x, z, 100, 33, 10);
            addBlockSpawn(BlockList.bauxiteStone.getDefaultState(), world, random, x, z, 100, 33, 10);
        }
    }

    public void addBlockSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos,
                              int maxY, int maxVeinSize, int chancesToSpawn) {
        for (int i = 0; i < chancesToSpawn; i++) {
            int firstBlockXCoord = (blockXPos * 16) + random.nextInt(16);
            int firstBlockYCoord = random.nextInt(maxY);
            int firstBlockZCoord = (blockZPos * 16) + random.nextInt(16);
            BlockPos position = new BlockPos(firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
            new WorldGenMinable(block, maxVeinSize).generate(world, random, position);
        }
    }
}
