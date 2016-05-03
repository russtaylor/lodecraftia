package us.vombat.lodecraftia.block;

import net.minecraft.block.BlockColored;
import net.minecraft.init.Blocks;
import us.vombat.lodecraftia.block.blocks.AndesiteStone;
import us.vombat.lodecraftia.block.blocks.BasaltStone;
import us.vombat.lodecraftia.block.blocks.BauxiteStone;
import us.vombat.lodecraftia.block.fences.DiamondFence;
import us.vombat.lodecraftia.block.fences.GoldFence;
import us.vombat.lodecraftia.block.fences.IronFence;
import us.vombat.lodecraftia.block.stairs.DiamondStairs;
import us.vombat.lodecraftia.block.stairs.GoldStairs;
import us.vombat.lodecraftia.block.stairs.HardenedClayStairs;
import us.vombat.lodecraftia.block.stairs.IronStairs;
import us.vombat.lodecraftia.block.stairs.LapisLazuliStairs;
import us.vombat.lodecraftia.block.stairs.PolishedAndesiteStairs;
import us.vombat.lodecraftia.block.stairs.PolishedDioriteStairs;
import us.vombat.lodecraftia.block.stairs.PolishedGraniteStairs;
import us.vombat.lodecraftia.block.stairs.SmoothSandstoneStairs;
import us.vombat.lodecraftia.block.walls.BrickWall;
import us.vombat.lodecraftia.block.walls.NetherBrickWall;
import us.vombat.lodecraftia.block.walls.NetherQuartzWall;
import us.vombat.lodecraftia.block.walls.SandstoneBrickWall;
import us.vombat.lodecraftia.block.walls.SandstoneWall;
import us.vombat.lodecraftia.block.walls.StoneBrickWall;
import us.vombat.lodecraftia.block.walls.StoneWall;
import us.vombat.lodecraftia.block.slabs.*;

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
        registerVanillaStairs();
        registerVanillaSlabs();
        registerStoneTypes();
    }

    private void registerStoneTypes() {
        BlockList.andesiteStone = new AndesiteStone().register();
        BlockList.basaltStone = new BasaltStone().register();
        BlockList.bauxiteStone   = new BauxiteStone().register();
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
        BlockList.dirtSlab = new DirtSlab(Blocks.dirt).register();
        BlockList.polishedAndesiteSlab = new PolishedAndesiteSlab(Blocks.stone).register();
        BlockList.polishedDioriteSlab = new PolishedDioriteSlab(Blocks.stone).register();
        BlockList.polishedGraniteSlab = new PolishedGraniteSlab(Blocks.stone).register();
        BlockList.lapisLazuliSlab = new LapisLazuliSlab(Blocks.lapis_block).register();
        BlockList.smoothSandstoneSlab = new SmoothSandstoneSlab(Blocks.sandstone).register();
    }
}
