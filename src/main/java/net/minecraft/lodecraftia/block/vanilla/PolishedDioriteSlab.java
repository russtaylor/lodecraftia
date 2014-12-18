package net.minecraft.lodecraftia.block.vanilla;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockSlab;

/**
 * Polished diorite slabs.
 *
 * Created by russt on 12/18/14.
 */
public class PolishedDioriteSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "polished-diorite-slab";
    public static final float BLOCK_HARDNESS = 1.5F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public PolishedDioriteSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
