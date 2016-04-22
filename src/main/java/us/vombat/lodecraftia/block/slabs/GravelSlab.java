package us.vombat.lodecraftia.block.slabs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockSlab;

/**
 * Gravel slabs.
 *
 * Created by russt on 12/18/14.
 */
public class GravelSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "gravel_slab";
    public static final float BLOCK_HARDNESS = 0.6F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public GravelSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
