package net.minecraft.lodecraftia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.lodecraftia.item.ModBlockSlabItem;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Parent class for all the slabs in the mod.
 *
 * Created by russt on 12/5/14.
 */
public class ModBlockSlab extends BlockSlab implements IModBlock {

    private String blockName;

    public ModBlockSlab(Block parentBlock, String blockName, float blockHardness, float blockResistance) {
        super(parentBlock.getMaterial());
        IBlockState iblockstate = this.blockState.getBaseState();
        this.blockName = blockName;
        setStepSound(parentBlock.stepSound);
        setHardness(blockHardness);
        setResistance(blockResistance);
        setCreativeTab(CreativeTabs.tabBlock);
        setUnlocalizedName(blockName);
        this.useNeighborBrightness = true;
    }

    @Override
    public String getFullSlabName(int meta) {
        return super.getUnlocalizedName();
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }

    /**
     * This one doesn't do anything yet, it seems?
     *
     * @return null. That's it.
     */
    @Override
    public IProperty func_176551_l() {
        return null;
    }

    @Override
    public Object func_176553_a(ItemStack p_176553_1_) {
        return null;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState();
        if(!this.isDouble())iblockstate = iblockstate.withProperty(HALF_PROP, (meta) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i;
        i = (byte) 0;

        if (!this.isDouble() && state.getValue(HALF_PROP) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockState createBlockState() {
        return this.isDouble() ? new BlockState(this): new BlockState(this, HALF_PROP);
    }

    @Override
    public String getBlockName() {
        return blockName;
    }

    public ModBlockSlab register(String blockName, ModBlockSlab singleSlab, ModBlockDoubleSlab doubleSlab) {
        GameRegistry.registerBlock(doubleSlab, ModBlockSlabItem.class, doubleSlab.getBlockName(), singleSlab, doubleSlab);
        GameRegistry.registerBlock(this, ModBlockSlabItem.class, blockName, singleSlab, doubleSlab);
        BlockList.blockList.add(this);
        return this;
    }
}
