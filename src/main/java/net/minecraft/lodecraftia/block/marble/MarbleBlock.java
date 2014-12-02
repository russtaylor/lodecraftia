package net.minecraft.lodecraftia.block.marble;

import net.minecraft.block.material.Material;
import net.minecraft.lodecraftia.block.ModBlock;

/**
 * Normal block of marble.
 *
 * Created by russt on 12/1/14.
 */
public class MarbleBlock extends ModBlock {
    public MarbleBlock() {
        super(
                Material.rock,
                "marble-block",
                4.0f,
                13.5f,
                soundTypeStone
        );
    }

    public ModBlock register() {
        return super.register("marble-block");
    }
}
