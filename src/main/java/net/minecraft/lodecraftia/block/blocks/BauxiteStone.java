package net.minecraft.lodecraftia.block.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.lodecraftia.block.ModBlock;

/**
 * Class for Bauxite Stone
 *
 * Created by russt on 3/5/2016.
 */
public class BauxiteStone extends ModBlock {

    public static final String BLOCK_NAME = "bauxite_stone";

    public BauxiteStone() {
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
