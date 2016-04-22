package us.vombat.lodecraftia.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import us.vombat.lodecraftia.block.ModBlock;

/**
 * Class for Basalt Stone
 *
 * Created by russt on 3/4/2016.
 */
public class BasaltStone extends ModBlock {

    public static final String BLOCK_NAME = "basalt_stone";

    public BasaltStone() {
        super(Material.rock,
                BLOCK_NAME,
                Blocks.stone.getBlockHardness(null, null),
                Blocks.stone.getExplosionResistance(null),
                Blocks.stone.stepSound);
    }

    public ModBlock register() {
        return register(BLOCK_NAME);
    }

}
