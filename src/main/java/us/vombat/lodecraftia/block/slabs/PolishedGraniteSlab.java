package us.vombat.lodecraftia.block.slabs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockSlab;

/**
 * Polished granite slabs.
 *
 * Created by russt on 12/18/14.
 */
public class PolishedGraniteSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "polished_granite_slab";
    public static final float BLOCK_HARDNESS = 1.5F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public PolishedGraniteSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
