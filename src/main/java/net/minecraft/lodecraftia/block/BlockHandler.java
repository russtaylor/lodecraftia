package net.minecraft.lodecraftia.block;

import net.minecraft.init.Blocks;
import net.minecraft.lodecraftia.block.vanilla.NetherBrickWall;
import net.minecraft.lodecraftia.block.vanilla.NetherQuartzWall;
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
    }
}
