package net.minecraft.vombat.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Contains stone-based Block Slabs for this mod.
 *
 * Created by russt on 11/22/14.
 */
public class VombatBlockSlab extends BlockSlab {

    private static Block singleSlab = null;

    public VombatBlockSlab (boolean isDoubleSlab) {
        super(Material.rock);
        if(!isDoubleSlab) {
            singleSlab = this;
        }
        this.useNeighborBrightness = true;
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
    public String getFullSlabName(int p_150002_1_) {
        return "tile.marble-slab";
    }

    @Override
    public boolean isDouble() {
        return false;
    }

    @Override
    public IProperty func_176551_l() {
        return null;
    }

    @Override
    public Object func_176553_a(ItemStack p_176553_1_) {
        return null;
    }
}
