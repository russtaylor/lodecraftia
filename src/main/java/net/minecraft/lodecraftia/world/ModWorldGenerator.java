package net.minecraft.lodecraftia.world;

import net.minecraft.lodecraftia.world.layer.GenLayerStone;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;

/**
 * Handles modified world generation (a sort of underground biomes with different stone types).
 *
 * Created by russt on 2016-03-07.
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
