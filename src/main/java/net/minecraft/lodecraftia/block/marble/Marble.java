package net.minecraft.lodecraftia.block.marble;

import net.minecraft.block.material.Material;
import net.minecraft.lodecraftia.block.ModBlock;

/**
 * Normal block of marble.
 *
 * Created by russt on 12/1/14.
 */
public class Marble extends ModBlock {

    public static final String BLOCK_NAME = "marble";

    public Marble() {
        super(Material.rock, BLOCK_NAME, 4.0f, 13.5f, soundTypeStone);
    }

    public ModBlock register() {
        return super.register(BLOCK_NAME);
    }
}
