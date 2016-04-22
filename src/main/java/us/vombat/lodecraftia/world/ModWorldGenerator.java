package us.vombat.lodecraftia.world;

import us.vombat.lodecraftia.world.layer.GenLayerStone;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;

/**
 * Handles modified world generation (a sort of underground biomes with different stone types).
 */
public class ModWorldGenerator {

    private long seed;
    private GenLayer stoneBiomesLayer;

    public ModWorldGenerator(long seed, WorldType worldType, String worldConfig) {
        this.seed = seed;
        long initialSeed = seed;

        GenLayer[] gen = GenLayerStone.initializeBiomeGenerators(seed, worldType, worldConfig);
    }
}
