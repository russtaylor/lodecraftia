package net.minecraft.lodecraftia.block;

import net.minecraft.block.Block;
import net.minecraft.lodecraftia.item.ModBlockSlabItem;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Class to act as a container for singleSlabs and doubleSlabs
 *
 * Created by russt on 12/17/14.
 */
public class ModBlockSlab {
    private final ModBlockSingleSlab singleSlab;
    private final ModBlockDoubleSlab doubleSlab;

    public ModBlockSlab(String singleSlabName, Block parentBlock, float blockHardness, float blockResistance) {
        this.singleSlab = new ModBlockSingleSlab(parentBlock, singleSlabName, blockHardness, blockResistance);
        this.doubleSlab = new ModBlockDoubleSlab(singleSlab, singleSlabName, blockHardness, blockResistance);
    }

    public ModBlockSingleSlab getSingleSlab() {
        return singleSlab;
    }

    public ModBlockDoubleSlab getDoubleSlab() {
        return doubleSlab;
    }

    public ModBlockSlab register() {
        GameRegistry.registerBlock(doubleSlab, null, doubleSlab.getBlockName(), singleSlab, doubleSlab);
        GameRegistry.registerBlock(singleSlab, ModBlockSlabItem.class, singleSlab.getBlockName(), singleSlab, doubleSlab);
        BlockList.blockList.add(singleSlab);
        return this;
    }
}
