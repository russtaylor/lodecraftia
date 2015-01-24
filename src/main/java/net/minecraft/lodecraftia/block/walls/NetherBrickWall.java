package net.minecraft.lodecraftia.block.walls;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockWall;

/**
 * Nether brick walls! Yay!
 *
 * Created by russt on 12/2/14.
 */
public class NetherBrickWall extends ModBlockWall {
    public static final String BLOCK_NAME = "nether-brick-wall";

    public NetherBrickWall(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
