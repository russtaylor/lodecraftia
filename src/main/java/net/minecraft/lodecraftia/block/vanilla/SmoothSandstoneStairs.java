package net.minecraft.lodecraftia.block.vanilla;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Smooth Sandstone Stairs.
 *
 * Created by russt on 12/18/14.
 */
public class SmoothSandstoneStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "smooth-sandstone-stairs";

    public SmoothSandstoneStairs(Block parent) {
        super(parent, parent.getDefaultState(), BLOCK_NAME);
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
