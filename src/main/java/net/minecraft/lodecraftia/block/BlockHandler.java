package net.minecraft.lodecraftia.block;

import net.minecraft.lodecraftia.block.marble.MarbleBlock;

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
    }

    private void registerMarble() {
        blockList.marbleBlock = new MarbleBlock().register();
    }
}
