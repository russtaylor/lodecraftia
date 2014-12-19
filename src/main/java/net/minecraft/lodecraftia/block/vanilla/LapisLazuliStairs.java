package net.minecraft.lodecraftia.block.vanilla;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Lapis Lazuli Stairs.
 *
 * Created by russt on 12/18/14.
 */
public class LapisLazuliStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "lapis-lazuli-stairs";

    public LapisLazuliStairs(Block parent) {
        super(parent, parent.getDefaultState(), BLOCK_NAME);
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
