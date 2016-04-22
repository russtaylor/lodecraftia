package us.vombat.lodecraftia.block.slabs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockSlab;

/**
 * Dirt slabs.
 *
 * Created by russt on 12/18/14.
 */
public class DirtSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "dirt_slab";
    public static final float BLOCK_HARDNESS = 0.5F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public DirtSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
