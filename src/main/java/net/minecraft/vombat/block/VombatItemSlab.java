package net.minecraft.vombat.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import net.minecraft.vombat.VombatMod;

/**
 * Created by russt on 11/24/14.
 */
public class VombatItemSlab extends ItemSlab {
    public VombatItemSlab(Block block) {
        super(block, (BlockSlab) VombatMod.marbleSlabSingle, (BlockSlab) VombatMod.marbleSlabDouble);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
}
