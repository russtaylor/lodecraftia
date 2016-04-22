package us.vombat.lodecraftia.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Parent class for all fences.
 *
 * Created by russt on 12/22/14.
 */
public class ModBlockFence extends Block implements IModBlock {

    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");

    private String blockName;

    public ModBlockFence(Block block, String blockName) {
        super(block.getMaterial());
        this.blockName = blockName;
        this.setDefaultState(this.blockState.getBaseState()
                .withProperty(NORTH, false)
                .withProperty(EAST, false)
                .withProperty(SOUTH, false)
                .withProperty(WEST, false));
        this.setHardness(block.getBlockHardness(null, null));
        this.setResistance(block.getExplosionResistance(null));
        this.setStepSound(block.stepSound);
        setUnlocalizedName(blockName);
        setCreativeTab(CreativeTabs.tabBlock);
        useNeighborBrightness = true;
    }

    @Override
    public String getBlockName() {
        return blockName;
    }

    public boolean isFullCube() {
        return false;
    }

    public boolean isPassable(IBlockAccess blockAccess, BlockPos pos) {
        return false;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockAccess access, BlockPos pos) {
        return true;
    }

    /**
     * Calculates the directions that the fence should face, based on the materials/blocks in each
     * adjacent block location.
     *
     * @param blockAccess block access
     * @param blockPos the specified position
     * @return Whether or not the fence should point toward the specified block.
     */
    public boolean calculateFenceDirection(IBlockAccess blockAccess, BlockPos blockPos) {
        Block block = blockAccess.getBlockState(blockPos).getBlock();
        if (block != this) {
            if (block != Blocks.barrier) {
                if (block.getMaterial().isOpaque()) {
                    if (block.isFullCube()) {
                        return Material.gourd != block.getMaterial();
                    }
                }
            }
            return false;
        } else {
            return block != Blocks.barrier;
        }
    }

    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity) {
        boolean northFlag = this.calculateFenceDirection(worldIn, pos.north());
        boolean southFlag = this.calculateFenceDirection(worldIn, pos.south());
        boolean westFlag = this.calculateFenceDirection(worldIn, pos.west());
        boolean eastFlag = this.calculateFenceDirection(worldIn, pos.east());
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (northFlag) {
            f2 = 0.0F;
        }

        if (southFlag) {
            f3 = 1.0F;
        }

        if (northFlag || southFlag) {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (westFlag) {
            f = 0.0F;
        }

        if (eastFlag) {
            f1 = 1.0F;
        }

        if (westFlag || eastFlag || !northFlag && !southFlag) {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        }

        if (northFlag) {
            f2 = 0.0F;
        }

        if (southFlag) {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos) {
        boolean northFlag = this.calculateFenceDirection(access, pos.north());
        boolean southFlag = this.calculateFenceDirection(access, pos.south());
        boolean westFlag = this.calculateFenceDirection(access, pos.west());
        boolean eastFlag = this.calculateFenceDirection(access, pos.east());
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (northFlag) {
            f2 = 0.0F;
        }

        if (southFlag) {
            f3 = 1.0F;
        }

        if (westFlag) {
            f = 0.0F;
        }

        if (eastFlag) {
            f1 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        this.setBlockBoundsBasedOnState(worldIn, pos);
        this.maxY = 1.5D;
        return super.getCollisionBoundingBox(worldIn, pos, state);
    }

    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(NORTH, this.calculateFenceDirection(worldIn, pos.north()))
                .withProperty(EAST, this.calculateFenceDirection(worldIn, pos.east()))
                .withProperty(SOUTH, this.calculateFenceDirection(worldIn, pos.south()))
                .withProperty(WEST, this.calculateFenceDirection(worldIn, pos.west()));
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState();
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return side == EnumFacing.DOWN || super.shouldSideBeRendered(worldIn, pos, side);
    }

    protected BlockState createBlockState() {
        IProperty[] properties = new IProperty[] {NORTH, EAST, SOUTH, WEST};
        return new BlockState(this, properties);
    }

    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    public ModBlockFence register(String blockName) {
        GameRegistry.registerBlock(this, blockName);
        BlockList.blockList.add(this);
        return this;
    }
}
