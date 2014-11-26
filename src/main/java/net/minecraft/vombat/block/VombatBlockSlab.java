package net.minecraft.vombat.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Contains stone-based Block Slabs for this mod.
 *
 * Created by russt on 11/22/14.
 */
public class VombatBlockSlab extends BlockSlab {

    private static Block singleSlab = null;

    public VombatBlockSlab (boolean isDoubleSlab) {
        super(isDoubleSlab, Material.rock);
        if(!isDoubleSlab) {
            singleSlab = this;
        }
        this.useNeighborBrightness = true;
    }

    @Override
    protected ItemStack createStackedBlock(int damage) {
        return new ItemStack(singleSlab, 2, damage & 7);
    }

    /* Was called getFullSlabName in pre 1.7 */
    @Override
    public String func_150002_b(int metadata) {
        return "tile.marble-slab";
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List itemList)
    {
        if (this == singleSlab)
        {
            itemList.add(new ItemStack(item, 1, 0));
        }
    }

    @Override
    public Item getItemDropped(int par1, Random par2Random, int par3) {
        return ItemBlock.getItemFromBlock(singleSlab);
    }
}
