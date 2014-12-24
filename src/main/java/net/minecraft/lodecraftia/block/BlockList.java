package net.minecraft.lodecraftia.block;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * The entirety of the list of blocks added by this mod.
 *
 * Created by russt on 12/1/14.
 */
public class BlockList {

    public static List<IModBlock> blockList = Lists.newArrayList();

    // Walls
    public static ModBlockWall netherQuartzWall;
    public static ModBlockWall netherBrickWall;
    public static ModBlockWall stoneWall;
    public static ModBlockWall stoneBrickWall;
    public static ModBlockWall sandstoneWall;
    public static ModBlockWall sandstoneBrickWall;
    public static ModBlockWall brickWall;

    // Fences
    public static ModBlockFence ironFence;
    public static ModBlockFence goldFence;
    public static ModBlockFence diamondFence;

    // Stairs
    public static ModBlockStairs ironStairs;
    public static ModBlockStairs goldStairs;
    public static ModBlockStairs polishedAndesiteStairs;
    public static ModBlockStairs polishedDioriteStairs;
    public static ModBlockStairs polishedGraniteStairs;
    public static ModBlockStairs lapisLazuliStairs;
    public static ModBlockStairs smoothSandstoneStairs;
    public static ModBlockStairs hardenedClayStairs;

    // Slabs
    public static ModBlockSlab ironSlab;
    public static ModBlockSlab goldSlab;
    public static ModBlockSlab polishedAndesiteSlab;
    public static ModBlockSlab polishedDioriteSlab;
    public static ModBlockSlab polishedGraniteSlab;
    public static ModBlockSlab lapisLazuliSlab;
    public static ModBlockSlab smoothSandstoneSlab;
}
