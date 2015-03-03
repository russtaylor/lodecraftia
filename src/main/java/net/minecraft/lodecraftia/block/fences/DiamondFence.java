package net.minecraft.lodecraftia.block.fences;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockFence;

/**
 * Diamond fences.
 *
 * Created by russt on 12/24/14.
 */
public class DiamondFence extends ModBlockFence {
    public static final String BLOCK_NAME = "diamond_fence";

    public DiamondFence(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockFence register() {
        return register(BLOCK_NAME);
    }
}
