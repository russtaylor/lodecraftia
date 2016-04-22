package us.vombat.lodecraftia.block.walls;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockWall;

/**
 * Stone walls.
 *
 * Created by russt on 12/2/14.
 */
public class StoneBrickWall extends ModBlockWall {
    public static final String BLOCK_NAME = "stone_brick_wall";

    public StoneBrickWall(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
