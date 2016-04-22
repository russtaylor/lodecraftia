package us.vombat.lodecraftia.block.stairs;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Gold Stairs.
 *
 * Created by russt on 12/2/14.
 */
public class GoldStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "gold_stairs";

    public GoldStairs(Block parent) {
        super(parent, parent.getDefaultState(), BLOCK_NAME);
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
