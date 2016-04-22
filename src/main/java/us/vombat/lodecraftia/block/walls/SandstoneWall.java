package us.vombat.lodecraftia.block.walls;

import net.minecraft.block.Block;
import us.vombat.lodecraftia.block.ModBlockWall;

/**
 * Stone walls.
 *
 * Created by russt on 12/2/14.
 */
public class SandstoneWall extends ModBlockWall {
    public static final String BLOCK_NAME = "sandstone_wall";

    public SandstoneWall(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
