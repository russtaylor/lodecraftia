package net.minecraft.lodecraftia.block;

import net.minecraft.lodecraftia.block.marble.Marble;
import net.minecraft.lodecraftia.block.marble.MarbleStairs;
import net.minecraft.lodecraftia.block.marble.MarbleWall;

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
        blockList.marble = new Marble().register();
        blockList.marbleStairs = new MarbleStairs((Marble) blockList.marble).register();
        blockList.marbleWall = new MarbleWall((Marble) blockList.marble).register();
    }
}
