package us.vombat.lodecraftia.world;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import us.vombat.lodecraftia.world.layer.GenLayerStone;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;

import java.util.Random;

/**
 * Handles modified world generation (a sort of underground biomes with different stone types).
 */
public class ModWorldGenerator implements IWorldGenerator {

    private long seed;
    private GenLayer stoneBiomesLayer;

    public ModWorldGenerator(long seed, WorldType worldType, String worldConfig) {
        this.seed = seed;
        long initialSeed = seed;

        GenLayer[] gen = GenLayerStone.initializeBiomeGenerators(seed, worldType, worldConfig);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimensionId()) {
            case -1: // Nether
                break;
            case 1: // The End
                break;
            default: // Overworld
                System.out.println("Generating a world.");
                break;
        }
    }
}
