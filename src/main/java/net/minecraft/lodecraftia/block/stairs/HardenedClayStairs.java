package net.minecraft.lodecraftia.block.stairs;

import net.minecraft.block.BlockColored;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.lodecraftia.block.ModBlockStairs;

/**
 * Custom class for Hardened Clay Stairs.
 *
 * Created by russt on 12/16/14.
 */
public class HardenedClayStairs extends ModBlockStairs {

    public static String BLOCK_NAME = "hardened-clay-stairs";

    public HardenedClayStairs(BlockColored parent) {
        super(parent, parent.getDefaultState(), BLOCK_NAME);
    }

    public MapColor getMapColor(IBlockState state)
    {
        return MapColor.adobeColor;
    }

    public ModBlockStairs register() {
        return register(BLOCK_NAME);
    }
}
