package net.minecraft.lodecraftia.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.lodecraftia.block.BlockList;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Handles creating the recipes needed by the mod.
 *
 * Created by russt on 12/12/14.
 */
public class RecipeHandler {
    public void registerRecipes() {
        ItemStack netherQuartzStack = new ItemStack(Blocks.quartz_block);
        GameRegistry.addRecipe(new ItemStack(BlockList.netherQuartzWall, 6), "xxx", "xxx", 'x', netherQuartzStack);
    }
}
