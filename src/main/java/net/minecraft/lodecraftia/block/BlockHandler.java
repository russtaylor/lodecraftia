package net.minecraft.lodecraftia.block;

import net.minecraft.init.Blocks;
import net.minecraft.lodecraftia.block.marble.Marble;
import net.minecraft.lodecraftia.block.marble.MarbleStairs;
import net.minecraft.lodecraftia.block.marble.MarbleWall;
import net.minecraft.lodecraftia.block.netherquartz.NetherQuartzWall;
import net.minecraft.lodecraftia.block.vanilla.NetherBrickWall;

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
        registerMarble();
        registerVanillaBlockExtensions();
    }

    private void registerMarble() {
        BlockList.marble = new Marble().register();
        BlockList.marbleStairs = new MarbleStairs((Marble) BlockList.marble).register();
        BlockList.marbleWall = new MarbleWall((Marble) BlockList.marble).register();
        BlockList.marbleSlabSingle = new ModBlockSlab(BlockList.marble, "marble-slab",
                BlockList.marble.getBlockHardness(), BlockList.marble.getBlockResistance());
        BlockList.marbleSlabDouble = new ModBlockDoubleSlab(BlockList.marbleSlabSingle,
                BlockList.marbleSlabSingle.getBlockName(),
                BlockList.marble.getBlockHardness(), BlockList.marble.getBlockResistance());
        BlockList.marbleSlabSingle.register(BlockList.marbleSlabSingle.getBlockName(),
                BlockList.marbleSlabSingle, BlockList.marbleSlabDouble);
    }

    private void registerVanillaBlockExtensions() {
        BlockList.netherQuartzWall = new NetherQuartzWall(Blocks.quartz_block).register();
        BlockList.netherBrickWall = new NetherBrickWall(Blocks.nether_brick).register();
    }
}
