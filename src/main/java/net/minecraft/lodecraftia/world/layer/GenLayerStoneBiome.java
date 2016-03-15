package net.minecraft.lodecraftia.world.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

/**
 * Handles generating the 'biomes' for stone.
 *
 * Created by russt on 2016-03-08.
 */
public class GenLayerStoneBiome extends GenLayer {

    public GenLayerStoneBiome(long seed, GenLayer genLayer, WorldType worldType) {
        super(seed);
        this.parent = genLayer;
    }

    @Override
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] parentInts = this.parent.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] intCache = IntCache.getIntCache(areaWidth * areaHeight);

        for (int height = 0; height < areaHeight; height++) {
            for (int width = 0; width < areaWidth; width++) {
                this.initChunkSeed((long)(width + areaX), (long)(height + areaY));
                int b = parentInts[width + height * areaWidth];
            }
        }

        return new int[0];
    }
}
