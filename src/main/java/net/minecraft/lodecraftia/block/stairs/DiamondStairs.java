package net.minecraft.lodecraftia.block.stairs;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Diamond Stairs.
 *
 * Created by russt on 3/5/15.
 */
public class DiamondStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "diamond_stairs";

    public DiamondStairs(Block parent) {
        super(parent, parent.getDefaultState(), BLOCK_NAME);
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
