package net.minecraft.lodecraftia.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * The parent class for all normal Blocks in this mod.
 *
 * Created by russt on 11/21/14.
 */
public class ModBlock extends Block implements IModBlock {

    private String blockName;

    public ModBlock(Material material, String blockName, float hardness, float resistance, SoundType sound) {
        super(material);
        this.blockName = blockName;
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(sound);
        this.setUnlocalizedName(blockName);
    }

    public String getBlockName() {
        return blockName;
    }

    public ModBlock register(String blockName) {
        GameRegistry.registerBlock(this, blockName);
        BlockList.blockList.add(this);
        return this;
    }
}
