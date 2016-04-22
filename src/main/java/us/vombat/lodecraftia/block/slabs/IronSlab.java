package us.vombat.lodecraftia.block.slabs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockSlab;

/**
 * Iron slabs.
 *
 * Created by russt on 12/2/14.
 */
public class IronSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "iron_slab";
    public static final float BLOCK_HARDNESS = 5.0F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public IronSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
