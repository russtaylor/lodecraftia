package us.vombat.lodecraftia.block.slabs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockSlab;

/**
 * Diamond slabs.
 *
 * Created by russt on 3/5/15.
 */
public class DiamondSlab extends ModBlockSlab {

    public static final String BLOCK_NAME = "diamond_slab";
    public static final float BLOCK_HARDNESS = 3.0F;
    public static final float BLOCK_RESISTANCE = 10.0F;

    public DiamondSlab(Block block) {
        super(BLOCK_NAME, block, BLOCK_HARDNESS, BLOCK_RESISTANCE);
    }

}
