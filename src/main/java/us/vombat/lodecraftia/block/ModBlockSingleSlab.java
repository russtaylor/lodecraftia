package us.vombat.lodecraftia.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Parent class for all the slabs in the mod.
 *
 * Created by russt on 12/5/14.
 */
public class ModBlockSingleSlab extends BlockSlab implements IModBlock {

    private String blockName;

    public ModBlockSingleSlab(Block parentBlock, String blockName, float blockHardness, float blockResistance) {
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
    public String getUnlocalizedName(int meta) {
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
    public IProperty getVariantProperty() {
        return null;
    }

    @Override
    public Object getVariant(ItemStack p_176553_1_) {
        return null;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        IBlockState iblockstate = this.getDefaultState();
        if(!this.isDouble())iblockstate = iblockstate.withProperty(HALF, (meta) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int i;
        i = (byte) 0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockState createBlockState() {
        return this.isDouble() ? new BlockState(this): new BlockState(this, HALF);
    }

    @Override
    public String getBlockName() {
        return blockName;
    }
}
