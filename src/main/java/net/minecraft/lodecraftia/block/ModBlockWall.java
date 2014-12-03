package net.minecraft.lodecraftia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Parent class for all walls.
 *
 * Created by russt on 12/2/14.
 */
public class ModBlockWall extends BlockWall implements IModBlock {

    private String blockName;

    public ModBlockWall(Block block, String blockName) {
        super(block);
        this.blockName = blockName;
        setUnlocalizedName(blockName);
        setCreativeTab(CreativeTabs.tabBlock);
        useNeighborBrightness = true;
    }

    @Override
    public String getBlockName() {
        return blockName;
    }

    public ModBlockWall register(String blockName) {
        GameRegistry.registerBlock(this, blockName);
        BlockList.blockList.add(this);
        return this;
    }
}
