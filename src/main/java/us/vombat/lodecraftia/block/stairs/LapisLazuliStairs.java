package us.vombat.lodecraftia.block.stairs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Lapis Lazuli Stairs.
 *
 * Created by russt on 12/18/14.
 */
public class LapisLazuliStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "lapis_lazuli_stairs";

    public LapisLazuliStairs(Block parent) {
        super(parent, parent.getDefaultState(), BLOCK_NAME);
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
