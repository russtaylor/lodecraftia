package net.minecraft.lodecraftia.recipe;

import net.minecraft.block.Block;
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
        registerWall(BlockList.netherQuartzWall, Blocks.quartz_block);
        registerWall(BlockList.netherBrickWall, Blocks.nether_brick);
        registerWall(BlockList.stoneWall, Blocks.stone);
        registerWall(BlockList.stoneBrickWall, Blocks.stonebrick);
    }

    public void registerWall(Block wallBlock, Block sourceBlock) {
        ItemStack sourceItemStack = new ItemStack(sourceBlock);
        ItemStack wallStack = new ItemStack(wallBlock, 6);
        GameRegistry.addRecipe(wallStack, "xxx", "xxx", 'x', sourceItemStack);
    }
}
