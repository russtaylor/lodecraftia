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

    public static ModBlockWall netherQuartzWall;
    public static ModBlockWall netherBrickWall;
    public static ModBlockWall stoneWall;
    public static ModBlockWall stoneBrickWall;
    public static ModBlockWall sandstoneWall;
    public static ModBlockWall sandstoneBrickWall;
    public static ModBlockWall brickWall;

    // Stairs
    public static ModBlockStairs ironStairs;
    public static ModBlockStairs goldStairs;
    public static ModBlockStairs polishedAndesiteStairs;
    public static ModBlockStairs polishedDioriteStairs;
    public static ModBlockStairs polishedGraniteStairs;
    public static ModBlockStairs hardenedClayStairs;

    // Slabs
    public static ModBlockSlab ironSlab;
}
