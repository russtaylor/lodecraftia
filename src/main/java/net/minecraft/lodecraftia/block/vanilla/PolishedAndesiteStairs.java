package net.minecraft.lodecraftia.block.vanilla;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Iron Stairs.
 *
 * Created by russt on 12/2/14.
 */
public class PolishedAndesiteStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "polished-andesite-stairs";

    public PolishedAndesiteStairs(Block parent) {
        super(parent, parent.getDefaultState(), BLOCK_NAME);
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
