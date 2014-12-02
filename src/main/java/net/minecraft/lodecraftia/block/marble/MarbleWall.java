package net.minecraft.lodecraftia.block.marble;

import net.minecraft.lodecraftia.block.ModBlockWall;

/**
 * Marble block walls! Yay!
 *
 * Created by russt on 12/2/14.
 */
public class MarbleWall extends ModBlockWall {
    public static final String BLOCK_NAME = "marble-wall";

    public MarbleWall(Marble marble) {
        super(marble, BLOCK_NAME);
    }

    public ModBlockWall register() {
        return register(BLOCK_NAME);
    }
}
