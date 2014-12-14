package net.minecraft.lodecraftia.block;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

/**
* Created by russt on 12/9/14.
*/
public class ModBlockDoubleSlab extends ModBlockSlab {

    private ModBlockSlab singleSlabBlock;

    public ModBlockDoubleSlab(ModBlockSlab singleSlabBlock, String blockName,
                              float blockHardness, float blockResistance) {
        super(singleSlabBlock, blockName + "-double", blockHardness, blockResistance);
        this.singleSlabBlock = singleSlabBlock;
        setCreativeTab(null);
    }

    @Override
    public boolean isDouble() {
        return true;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random par2random, int par3) {
        return Item.getItemFromBlock(BlockList.marbleSlabSingle);
    }
}
