package net.minecraft.lodecraftia.block.marble;

import net.minecraft.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Marble Block Stairs.
 *
 * Created by russt on 12/2/14.
 */
public class MarbleStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "marble-stairs";

    public MarbleStairs(Marble marble) {
        super(marble, marble.getDefaultState(), BLOCK_NAME);
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
