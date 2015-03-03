package net.minecraft.lodecraftia.block.walls;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.block.ModBlockWall;

/**
 * Quartz walls! Yay!
 *
 * Created by russt on 12/2/14.
 */
public class NetherQuartzWall extends ModBlockWall {
    public static final String BLOCK_NAME = "nether_quartz_wall";

    public NetherQuartzWall(Block block) {
        super(block, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
