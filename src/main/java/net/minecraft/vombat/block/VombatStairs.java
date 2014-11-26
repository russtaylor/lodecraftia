package net.minecraft.vombat.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

/**
 * Created by russt on 11/23/14.
 */
public class VombatStairs extends BlockStairs {
    public VombatStairs (Block block, int par3) {
        super(block, par3);
        this.useNeighborBrightness = true;
    }
}
