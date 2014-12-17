package net.minecraft.lodecraftia.block;

import net.minecraft.init.Blocks;
import net.minecraft.lodecraftia.block.vanilla.BrickWall;
import net.minecraft.lodecraftia.block.vanilla.GoldStairs;
import net.minecraft.lodecraftia.block.vanilla.HardenedClayStairs;
import net.minecraft.lodecraftia.block.vanilla.IronStairs;
import net.minecraft.lodecraftia.block.vanilla.NetherBrickWall;
import net.minecraft.lodecraftia.block.vanilla.NetherQuartzWall;
import net.minecraft.lodecraftia.block.vanilla.PolishedAndesiteStairs;
import net.minecraft.lodecraftia.block.vanilla.PolishedDioriteStairs;
import net.minecraft.lodecraftia.block.vanilla.PolishedGraniteStairs;
import net.minecraft.lodecraftia.block.vanilla.SandstoneBrickWall;
import net.minecraft.lodecraftia.block.vanilla.SandstoneWall;
import net.minecraft.lodecraftia.block.vanilla.StoneBrickWall;
import net.minecraft.lodecraftia.block.vanilla.StoneWall;

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
        BlockList.netherQuartzWall = new NetherQuartzWall(Blocks.quartz_block).register();
        BlockList.netherBrickWall = new NetherBrickWall(Blocks.nether_brick).register();
        BlockList.stoneWall = new StoneWall(Blocks.stone).register();
        BlockList.stoneBrickWall = new StoneBrickWall(Blocks.stonebrick).register();
        BlockList.sandstoneWall = new SandstoneWall(Blocks.sandstone).register();
        BlockList.sandstoneBrickWall = new SandstoneBrickWall(Blocks.sandstone).register();
        BlockList.brickWall = new BrickWall(Blocks.brick_block).register();

        BlockList.ironStairs = new IronStairs(Blocks.iron_block).register();
        BlockList.goldStairs = new GoldStairs(Blocks.gold_block).register();
        BlockList.polishedAndesiteStairs = new PolishedAndesiteStairs(Blocks.stone).register();
        BlockList.polishedDioriteStairs = new PolishedDioriteStairs(Blocks.stone).register();
        BlockList.polishedGraniteStairs = new PolishedGraniteStairs(Blocks.stone).register();
        BlockList.hardenedClayStairs = new HardenedClayStairs(Blocks.hardened_clay).register();
    }
}
