package net.minecraft.lodecraftia.block;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import net.minecraft.lodecraftia.block.fences.DiamondFence;
import net.minecraft.lodecraftia.block.fences.GoldFence;
import net.minecraft.lodecraftia.block.fences.IronFence;
import net.minecraft.lodecraftia.block.slabs.*;
import net.minecraft.lodecraftia.block.stairs.DiamondStairs;
import net.minecraft.lodecraftia.block.stairs.GoldStairs;
import net.minecraft.lodecraftia.block.stairs.HardenedClayStairs;
import net.minecraft.lodecraftia.block.stairs.IronStairs;
import net.minecraft.lodecraftia.block.stairs.LapisLazuliStairs;
import net.minecraft.lodecraftia.block.stairs.PolishedAndesiteStairs;
import net.minecraft.lodecraftia.block.stairs.PolishedDioriteStairs;
import net.minecraft.lodecraftia.block.stairs.PolishedGraniteStairs;
import net.minecraft.lodecraftia.block.stairs.SmoothSandstoneStairs;
import net.minecraft.lodecraftia.block.walls.BrickWall;
import net.minecraft.lodecraftia.block.walls.NetherBrickWall;
import net.minecraft.lodecraftia.block.walls.NetherQuartzWall;
import net.minecraft.lodecraftia.block.walls.SandstoneBrickWall;
import net.minecraft.lodecraftia.block.walls.SandstoneWall;
import net.minecraft.lodecraftia.block.walls.StoneBrickWall;
import net.minecraft.lodecraftia.block.walls.StoneWall;

/**
 * Handles the creation of various types of blocks.
 *
 * Created by russt on 11/26/14.
 */
public class BlockHandler {

    public BlockList blockList;

    public BlockHandler() {
        blockList = new BlockList();
    }

    public void registerBlocks() {
        registerVanillaBlockExtensions();
    }

    private void registerVanillaBlockExtensions() {
        registerVanillaWalls();
        registerVanillaFences();
        registerVanillaStairs();
        registerVanillaSlabs();
    }

    private void registerVanillaWalls() {
        BlockList.netherQuartzWall = new NetherQuartzWall(Blocks.quartz_block).register();
        BlockList.netherBrickWall = new NetherBrickWall(Blocks.nether_brick).register();
        BlockList.stoneWall = new StoneWall(Blocks.stone).register();
        BlockList.stoneBrickWall = new StoneBrickWall(Blocks.stonebrick).register();
        BlockList.sandstoneWall = new SandstoneWall(Blocks.sandstone).register();
        BlockList.sandstoneBrickWall = new SandstoneBrickWall(Blocks.sandstone).register();
        BlockList.brickWall = new BrickWall(Blocks.brick_block).register();
    }

    private void registerVanillaFences() {
        BlockList.ironFence = new IronFence(Blocks.iron_block).register();
        BlockList.goldFence = new GoldFence(Blocks.gold_block).register();
        BlockList.diamondFence = new DiamondFence(Blocks.diamond_block).register();
    }

    private void registerVanillaStairs() {
        BlockList.ironStairs = new IronStairs(Blocks.iron_block).register();
        BlockList.goldStairs = new GoldStairs(Blocks.gold_block).register();
        BlockList.diamondStairs = new DiamondStairs(Blocks.diamond_block).register();
        BlockList.polishedAndesiteStairs = new PolishedAndesiteStairs(Blocks.stone).register();
        BlockList.polishedDioriteStairs = new PolishedDioriteStairs(Blocks.stone).register();
        BlockList.polishedGraniteStairs = new PolishedGraniteStairs(Blocks.stone).register();
        BlockList.lapisLazuliStairs = new LapisLazuliStairs(Blocks.lapis_block).register();
        BlockList.smoothSandstoneStairs = new SmoothSandstoneStairs(Blocks.sandstone).register();
        BlockList.hardenedClayStairs = new HardenedClayStairs((BlockColored) Blocks.stained_hardened_clay).register();
    }

    private void registerVanillaSlabs() {
        BlockList.diamondSlab = new DiamondSlab(Blocks.diamond_block).register();
        BlockList.ironSlab = new IronSlab(Blocks.iron_block).register();
        BlockList.goldSlab = new GoldSlab(Blocks.gold_block).register();
        BlockList.gravelSlab = new GravelSlab(Blocks.gravel).register();
        BlockList.polishedAndesiteSlab = new PolishedAndesiteSlab(Blocks.stone).register();
        BlockList.polishedDioriteSlab = new PolishedDioriteSlab(Blocks.stone).register();
        BlockList.polishedGraniteSlab = new PolishedGraniteSlab(Blocks.stone).register();
        BlockList.lapisLazuliSlab = new LapisLazuliSlab(Blocks.lapis_block).register();
        BlockList.smoothSandstoneSlab = new SmoothSandstoneSlab(Blocks.sandstone).register();
    }
}
