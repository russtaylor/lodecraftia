package net.minecraft.lodecraftia.block.walls;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockWall;

/**
 * Brick walls.
 *
 * Created by russt on 12/2/14.
 */
public class BrickWall extends ModBlockWall {
    public static final String BLOCK_NAME = "brick-wall";

    public BrickWall(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
