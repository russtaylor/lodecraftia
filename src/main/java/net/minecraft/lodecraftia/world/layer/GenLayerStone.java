package net.minecraft.lodecraftia.world.layer;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.layer.*;

/**
 * Handles generation of the 'stone' layer.
 *
 * Created by russt on 2016-03-08.
 */
public abstract class GenLayerStone extends GenLayer {

    public GenLayerStone(long argument1) {
        super(argument1);
    }


    public static GenLayer[] initializeBiomeGenerators(long seed, WorldType worldType, String config) {
        // We need to do essentially the same here as in Minecraft's 'GenLayer'
        GenLayerIsland genLayerIsland = new GenLayerIsland(1L);
        GenLayerFuzzyZoom genLayerFuzzyZoom = new GenLayerFuzzyZoom(2000L, genLayerIsland);
        GenLayerAddIsland genLayerAddIsland = new GenLayerAddIsland(1L, genLayerFuzzyZoom);
        GenLayerZoom genLayerZoom = new GenLayerZoom(2001L, genLayerAddIsland);
        genLayerAddIsland = new GenLayerAddIsland(2L, genLayerZoom);
        genLayerAddIsland = new GenLayerAddIsland(50L, genLayerAddIsland);
        genLayerAddIsland = new GenLayerAddIsland(70L, genLayerAddIsland);
        GenLayerRemoveTooMuchOcean genLayerRemoveTooMuchOcean = new GenLayerRemoveTooMuchOcean(2L, genLayerAddIsland);
        GenLayerAddSnow genLayerAddSnow = new GenLayerAddSnow(2L, genLayerRemoveTooMuchOcean);
        genLayerAddIsland = new GenLayerAddIsland(3L, genLayerAddSnow);
        GenLayerEdge genLayerEdge = new GenLayerEdge(2L, genLayerAddIsland, GenLayerEdge.Mode.COOL_WARM);
        genLayerEdge = new GenLayerEdge(2L, genLayerEdge, GenLayerEdge.Mode.HEAT_ICE);
        genLayerEdge = new GenLayerEdge(3L, genLayerEdge, GenLayerEdge.Mode.SPECIAL);
        genLayerZoom = new GenLayerZoom(2002L, genLayerEdge);
        genLayerZoom = new GenLayerZoom(2003L, genLayerZoom);
        genLayerAddIsland = new GenLayerAddIsland(4L, genLayerZoom);
        GenLayerAddMushroomIsland genLayerAddMushroomIsland = new GenLayerAddMushroomIsland(5L, genLayerAddIsland);
        GenLayerDeepOcean genLayerDeepOcean = new GenLayerDeepOcean(4L, genLayerAddMushroomIsland);
        GenLayer genLayer2 = GenLayerZoom.magnify(1000L, genLayerDeepOcean, 0);
        ChunkProviderSettings chunkProviderSettings;
        int j = 4;
        int k = j;

        if (worldType == WorldType.CUSTOMIZED && config.length() > 0) {
            chunkProviderSettings = ChunkProviderSettings.Factory.jsonToFactory(config).func_177864_b();
            j = chunkProviderSettings.biomeSize;
            k = chunkProviderSettings.biomeSize;
        }

        if (worldType == WorldType.LARGE_BIOMES) {
            j = 6;
        }

        j = getModdedBiomeSize(worldType, j);

        GenLayer genLayer = GenLayerZoom.magnify(1000L, genLayer2, 0);
        GenLayerRiverInit genLayerRiverinit = new GenLayerRiverInit(100L, genLayer);
        GenLayer genLayerBiomeEdge = worldType.getBiomeLayer(seed, genLayer2, config);
        GenLayer genLayer1 = GenLayerZoom.magnify(1000L, genLayerRiverinit, 2);
        GenLayerHills genLayerHills = new GenLayerHills(1000L, genLayerBiomeEdge, genLayer1);
        genLayer = GenLayerZoom.magnify(1000L, genLayerRiverinit, 2);
        genLayer = GenLayerZoom.magnify(1000L, genLayer, k);
        GenLayerRiver genLayerRiver = new GenLayerRiver(1L, genLayer);
        GenLayerSmooth genLayerSmooth = new GenLayerSmooth(1000L, genLayerRiver);
        Object object = new GenLayerRareBiome(1001L, genLayerHills);

        for (int l = 0; l < j; ++l) {
            object = new GenLayerZoom((long)(1000 + l), (GenLayer)object);

            if (l == 0) {
                object = new GenLayerAddIsland(3L, (GenLayer)object);
            }

            if (l == 1 || j == 1) {
                object = new GenLayerShore(1000L, (GenLayer)object);
            }
        }

        GenLayerSmooth genLayerSmooth1 = new GenLayerSmooth(1000L, (GenLayer)object);
        GenLayerRiverMix genLayerRiverMix = new GenLayerRiverMix(100L, genLayerSmooth1, genLayerSmooth);
        GenLayerVoronoiZoom genLayerVoronoiZoom = new GenLayerVoronoiZoom(10L, genLayerRiverMix);
        genLayerRiverMix.initWorldGenSeed(seed);
        genLayerVoronoiZoom.initWorldGenSeed(seed);
        return new GenLayer[] {genLayerRiverMix, genLayerVoronoiZoom, genLayerRiverMix};
    }
}
