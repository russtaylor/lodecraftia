package net.minecraft.lodecraftia.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

/**
 * ItemSlab
 *
 * Created by russt on 11/24/14.
 */
public class ModItemSlab extends ItemSlab {
    public ModItemSlab(Block block, BlockSlab singleSlab, BlockSlab slabDouble) {
        super(block, singleSlab, slabDouble);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
}
