package net.minecraft.lodecraftia.block.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

/**
 * Class for Andesite Brick
 *
 * Created by russt on 12/29/14.
 */
public class AndesiteBrick extends Block {

    public AndesiteBrick() {
        super(Material.rock);
    }

    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, BlockPos blockPos, EnumFacing side) {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

}
