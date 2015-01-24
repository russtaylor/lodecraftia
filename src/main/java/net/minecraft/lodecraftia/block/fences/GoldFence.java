package net.minecraft.lodecraftia.block.fences;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockFence;

/**
 * Gold fences.
 *
 * Created by russt on 12/2/14.
 */
public class GoldFence extends ModBlockFence {
    public static final String BLOCK_NAME = "gold-fence";

    public GoldFence(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockFence register() {
        return register(BLOCK_NAME);
    }
}
