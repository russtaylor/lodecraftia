package net.minecraft.vombat.block;

import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.vombat.VombatMod;

/**
 * Created by russt on 11/25/14.
 */
public class VombatBlockWall extends BlockWall{
    public VombatBlockWall() {
        super(VombatMod.marbleBlock);
        setCreativeTab(CreativeTabs.tabBlock);
    }
}
