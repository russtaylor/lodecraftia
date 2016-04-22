package us.vombat.lodecraftia.block.walls;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockWall;

/**
 * Brick walls.
 *
 * Created by russt on 12/2/14.
 */
public class BrickWall extends ModBlockWall {
    public static final String BLOCK_NAME = "brick_wall";

    public BrickWall(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
