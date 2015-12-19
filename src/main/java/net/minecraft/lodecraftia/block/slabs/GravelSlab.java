package net.minecraft.lodecraftia.block.slabs;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockSlab;

/**
 * Gold slabs.
 *
 * Created by russt on 12/18/14.
 */
public class GravelSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "gold_slab";
    public static final float BLOCK_HARDNESS = 3.0F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public GravelSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
