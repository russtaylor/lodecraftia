package net.minecraft.lodecraftia.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.lodecraftia.block.ModBlock;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

/**
 * Class for Andesite Stone
 *
 * Created by russt on 3/4/2016.
 */
public class AndesiteStone extends ModBlock {

    public static final String BLOCK_NAME = "andesite_stone";

    public AndesiteStone() {
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
