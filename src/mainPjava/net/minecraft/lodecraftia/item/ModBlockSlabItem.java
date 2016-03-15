package net.minecraft.lodecraftia.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.lodecraftia.block.ModBlockDoubleSlab;
import net.minecraft.lodecraftia.block.ModBlockSingleSlab;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockSlabItem extends ItemBlock {
    private final BlockSlab singleSlab;
    private final BlockSlab doubleSlab;

    public ModBlockSlabItem(Block block, ModBlockSingleSlab singleSlab, ModBlockDoubleSlab doubleSlab) {
        super(block);
        this.singleSlab = singleSlab;
        this.doubleSlab = doubleSlab;
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return this.singleSlab.getUnlocalizedName(stack.getMetadata());
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (stack.stackSize == 0 || !playerIn.canPlayerEdit(pos.offset(side), side, stack)) {
            return false;
        } else {
            Object object = this.singleSlab.getVariant(stack);
            IBlockState iblockstate = worldIn.getBlockState(pos);

            if (iblockstate.getBlock() == this.singleSlab) {
                BlockSlab.EnumBlockHalf enumBlockHalf = (BlockSlab.EnumBlockHalf) iblockstate.getValue(BlockSlab.HALF);

                if ((side == EnumFacing.UP && enumBlockHalf == BlockSlab.EnumBlockHalf.BOTTOM || side == EnumFacing.DOWN && enumBlockHalf == BlockSlab.EnumBlockHalf.TOP)) {
                    IBlockState iblockstate1 = this.doubleSlab.getDefaultState();

                    if (worldIn.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBox(worldIn, pos, iblockstate1)) && worldIn.setBlockState(pos, iblockstate1, 3)) {
                        worldIn.playSoundEffect((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), this.doubleSlab.stepSound.getPlaceSound(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getFrequency() * 0.8F);
                        --stack.stackSize;
                    }

                    return true;
                }
            }

            return this.func_180615_a(stack, worldIn, pos.offset(side), object) || super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean canPlaceBlockOnSide(World worldIn, BlockPos p_179222_2_, EnumFacing p_179222_3_, EntityPlayer p_179222_4_, ItemStack p_179222_5_)
    {
        BlockPos blockPos = p_179222_2_;
        Object object = this.singleSlab.getVariant(p_179222_5_);
        IBlockState iblockstate = worldIn.getBlockState(p_179222_2_);

        if (iblockstate.getBlock() == this.singleSlab)
        {
            boolean flag = iblockstate.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP;

            if ((p_179222_3_ == EnumFacing.UP && !flag || p_179222_3_ == EnumFacing.DOWN && flag))
            {
                return true;
            }
        }

        p_179222_2_ = p_179222_2_.offset(p_179222_3_);
        IBlockState iBlockState = worldIn.getBlockState(p_179222_2_);
        return iBlockState.getBlock() == this.singleSlab || super.canPlaceBlockOnSide(worldIn, blockPos, p_179222_3_, p_179222_4_, p_179222_5_);
    }

    private boolean func_180615_a(ItemStack p_180615_1_, World worldIn, BlockPos p_180615_3_, Object p_180615_4_)
    {
        IBlockState iblockstate = worldIn.getBlockState(p_180615_3_);

        if (iblockstate.getBlock() == this.singleSlab)
        {
            IBlockState iBlockState = this.doubleSlab.getDefaultState();

            if (worldIn.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBox(worldIn, p_180615_3_, iBlockState)) && worldIn.setBlockState(p_180615_3_, iBlockState, 3))
            {
                worldIn.playSoundEffect((double)((float)p_180615_3_.getX() + 0.5F), (double)((float)p_180615_3_.getY() + 0.5F), (double)((float)p_180615_3_.getZ() + 0.5F), this.doubleSlab.stepSound.getPlaceSound(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getFrequency() * 0.8F);
                --p_180615_1_.stackSize;
            }

            return true;
        }

        return false;
    }
}