package net.minecraft.lodecraftia.recipe;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.lodecraftia.block.BlockList;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Handles creating the recipes needed by the mod.
 *
 * Created by russt on 12/12/14.
 */
public class RecipeHandler {
    public void registerRecipes() {
        removeVanillaRecipes();
        registerWallRecipes();
        registerStairRecipes();
        registerSlabRecipes();
        reregisterVanillaRecipes();
    }

    public void registerWallRecipes() {
        registerWall(BlockList.netherQuartzWall, Blocks.quartz_block);
        registerWall(BlockList.netherBrickWall, Blocks.nether_brick);
        registerWall(BlockList.stoneWall, Blocks.stone);
        registerWall(BlockList.stoneBrickWall, Blocks.stonebrick);
        registerWall(BlockList.sandstoneWall, Blocks.sandstone);
        registerWall(BlockList.sandstoneBrickWall, Blocks.sandstone, BlockSandStone.EnumType.SMOOTH.func_176675_a());
        registerWall(BlockList.brickWall, Blocks.brick_block);
    }

    public void registerStairRecipes() {
        registerStair(BlockList.ironStairs, Blocks.iron_block);
        registerStair(BlockList.goldStairs, Blocks.gold_block);
        registerStair(BlockList.polishedAndesiteStairs, Blocks.stone, BlockStone.EnumType.ANDESITE_SMOOTH.getMetaFromState());
        registerStair(BlockList.polishedDioriteStairs, Blocks.stone, BlockStone.EnumType.DIORITE_SMOOTH.getMetaFromState());
        registerStair(BlockList.polishedGraniteStairs, Blocks.stone, BlockStone.EnumType.GRANITE_SMOOTH.getMetaFromState());
        registerStair(BlockList.lapisLazuliStairs, Blocks.lapis_block);
        registerStair(BlockList.smoothSandstoneStairs, Blocks.sandstone, BlockSandStone.EnumType.SMOOTH.func_176675_a());
    }

    public void registerSlabRecipes() {
        registerSlab(BlockList.ironSlab.getSingleSlab(), Blocks.iron_block);
        registerSlab(BlockList.goldSlab.getSingleSlab(), Blocks.gold_block);
        registerSlab(BlockList.polishedAndesiteSlab.getSingleSlab(), Blocks.stone, BlockStone.EnumType.ANDESITE_SMOOTH.getMetaFromState());
        registerSlab(BlockList.polishedDioriteSlab.getSingleSlab(), Blocks.stone, BlockStone.EnumType.DIORITE_SMOOTH.getMetaFromState());
        registerSlab(BlockList.polishedGraniteSlab.getSingleSlab(), Blocks.stone, BlockStone.EnumType.GRANITE_SMOOTH.getMetaFromState());
        registerSlab(BlockList.lapisLazuliSlab.getSingleSlab(), Blocks.lapis_block);
        registerSlab(BlockList.smoothSandstoneSlab.getSingleSlab(), Blocks.sandstone, BlockSandStone.EnumType.SMOOTH.func_176675_a());
    }

    public void removeVanillaRecipes() {
        removeRecipe(Item.getItemFromBlock(Blocks.sandstone_stairs));
        removeRecipe(new ItemStack(Blocks.stone_slab, 1, BlockStoneSlab.EnumType.SAND.func_176624_a()).getItem());
    }

    public void reregisterVanillaRecipes() {
        registerStair(Blocks.sandstone_stairs, Blocks.sandstone, BlockSandStone.EnumType.DEFAULT.func_176675_a());

        // Re-register normal sandstone slabs.
        ItemStack normalSandstoneSlabStack = new ItemStack(Blocks.stone_slab, 6, BlockStoneSlab.EnumType.SAND.func_176624_a());
        ItemStack normalSandstone = new ItemStack(Blocks.sandstone, 1, BlockSandStone.EnumType.DEFAULT.func_176675_a());
        registerSlab(normalSandstone, normalSandstoneSlabStack);
    }

    public void removeRecipe(Item item) {
        List recipeList = CraftingManager.getInstance().getRecipeList();

        Iterator remover = recipeList.iterator();
        while(remover.hasNext()) {
            Object recipeObject = remover.next();
            if(recipeObject instanceof IRecipe) {
                IRecipe recipe = (IRecipe) recipeObject;
                ItemStack itemStack = recipe.getRecipeOutput();
                if(itemStack != null && itemStack.getItem() == item) {
                    remover.remove();
                }
            }
        }
    }

    public void registerStair(Block stairBlock, Block sourceBlock) {
        this.registerStair(stairBlock, sourceBlock, 0);
    }

    public void registerStair(Block stairBlock, Block sourceBlock, int meta) {
        ItemStack sourceItemStack = new ItemStack(sourceBlock, 1, meta);
        ItemStack stairStack = new ItemStack(stairBlock, 6);
        GameRegistry.addRecipe(stairStack, "  x", " xx", "xxx", 'x', sourceItemStack);
    }

    public void registerSlab(Block slabBlock, Block sourceBlock) {
        this.registerSlab(slabBlock, sourceBlock, 0);
    }

    public void registerSlab(Block slabBlock, Block sourceBlock, int meta) {
        ItemStack sourceItemStack = new ItemStack(sourceBlock, 1, meta);
        ItemStack slabStack = new ItemStack(slabBlock, 6);
        registerSlab(sourceItemStack, slabStack);
    }

    public void registerSlab(ItemStack sourceItemStack, ItemStack slabStack) {
        GameRegistry.addRecipe(slabStack, "xxx", 'x', sourceItemStack);
    }

    public void registerWall(Block wallBlock, Block sourceBlock) {
        this.registerWall(wallBlock, sourceBlock, 0);
    }

    public void registerWall(Block wallBlock, Block sourceBlock, int meta) {
        ItemStack sourceItemStack = new ItemStack(sourceBlock, 1, meta);
        ItemStack wallStack = new ItemStack(wallBlock, 6);
        GameRegistry.addRecipe(wallStack, "xxx", "xxx", 'x', sourceItemStack);
    }
}
