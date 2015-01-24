package net.minecraft.lodecraftia.block.fences;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockFence;

/**
 * Iron fences.
 *
 * Created by russt on 12/2/14.
 */
public class IronFence extends ModBlockFence {
    public static final String BLOCK_NAME = "iron-fence";

    public IronFence(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockFence register() {
        return register(BLOCK_NAME);
    }
}
