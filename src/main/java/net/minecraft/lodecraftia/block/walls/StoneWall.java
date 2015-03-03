package net.minecraft.lodecraftia.block.walls;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockWall;

/**
 * Stone walls.
 *
 * Created by russt on 12/2/14.
 */
public class StoneWall extends ModBlockWall {
    public static final String BLOCK_NAME = "stone_wall";

    public StoneWall(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
