package us.vombat.lodecraftia.block.slabs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockSlab;

/**
 * Lapis Lazuli slabs.
 *
 * Created by russt on 12/19/14.
 */
public class SmoothSandstoneSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "smooth_sandstone_slab";
    public static final float BLOCK_HARDNESS = 1.5F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public SmoothSandstoneSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
