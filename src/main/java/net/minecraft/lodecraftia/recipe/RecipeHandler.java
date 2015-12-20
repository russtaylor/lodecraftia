package net.minecraft.lodecraftia.recipe;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.lodecraftia.block.BlockList;
import net.minecraft.lodecraftia.item.ItemList;
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
        registerRodRecipes();
        registerFenceRecipes();
        reregisterVanillaRecipes();
    }

    private void registerRodRecipes() {
        registerRod(Items.iron_ingot, ItemList.ironRod);
        registerRod(Items.diamond, ItemList.diamondRod);
        registerRod(Items.gold_ingot, ItemList.goldRod);
    }

    private void registerRod(Item inputItem, Item outputItem) {
        ItemStack inputItemStack = new ItemStack(inputItem, 1);
        ItemStack outputItemStack = new ItemStack(outputItem, 4);
        GameRegistry.addRecipe(outputItemStack, "x", "x", 'x', inputItemStack);
    }

    private void registerFenceRecipes() {
        registerFence(BlockList.ironFence, Blocks.iron_ore, ItemList.ironRod);
        registerFence(BlockList.goldFence, Blocks.gold_ore, ItemList.goldRod);
        registerFence(BlockList.diamondFence, Blocks.diamond_ore, ItemList.diamondRod);
    }

    private void registerWallRecipes() {
        registerWall(BlockList.netherQuartzWall, Blocks.quartz_block);
        registerWall(BlockList.netherBrickWall, Blocks.nether_brick);
        registerWall(BlockList.stoneWall, Blocks.stone);
        registerWall(BlockList.stoneBrickWall, Blocks.stonebrick);
        registerWall(BlockList.sandstoneWall, Blocks.sandstone);
        registerWall(BlockList.sandstoneBrickWall, Blocks.sandstone, BlockSandStone.EnumType.SMOOTH.func_176675_a());
        registerWall(BlockList.brickWall, Blocks.brick_block);
    }

    private void registerStairRecipes() {
        registerStair(BlockList.ironStairs, Blocks.iron_block);
        registerStair(BlockList.goldStairs, Blocks.gold_block);
        registerStair(BlockList.polishedAndesiteStairs, Blocks.stone, BlockStone.EnumType.ANDESITE_SMOOTH.getMetaFromState());
        registerStair(BlockList.polishedDioriteStairs, Blocks.stone, BlockStone.EnumType.DIORITE_SMOOTH.getMetaFromState());
        registerStair(BlockList.polishedGraniteStairs, Blocks.stone, BlockStone.EnumType.GRANITE_SMOOTH.getMetaFromState());
        registerStair(BlockList.lapisLazuliStairs, Blocks.lapis_block);
        registerStair(BlockList.smoothSandstoneStairs, Blocks.sandstone, BlockSandStone.EnumType.SMOOTH.func_176675_a());
    }

    private void registerSlabRecipes() {
        registerSlab(BlockList.ironSlab.getSingleSlab(), Blocks.iron_block);
        registerSlab(BlockList.goldSlab.getSingleSlab(), Blocks.gold_block);
        registerSlab(BlockList.gravelSlab.getSingleSlab(), Blocks.gravel);
        registerSlab(BlockList.dirtSlab.getSingleSlab(), Blocks.dirt);
        registerSlab(BlockList.polishedAndesiteSlab.getSingleSlab(), 0, Blocks.stone, BlockStone.EnumType.ANDESITE_SMOOTH.getMetaFromState());
        registerSlab(BlockList.polishedDioriteSlab.getSingleSlab(), 0, Blocks.stone, BlockStone.EnumType.DIORITE_SMOOTH.getMetaFromState());
        registerSlab(BlockList.polishedGraniteSlab.getSingleSlab(), 0, Blocks.stone, BlockStone.EnumType.GRANITE_SMOOTH.getMetaFromState());
        registerSlab(BlockList.lapisLazuliSlab.getSingleSlab(), Blocks.lapis_block);
        registerSlab(BlockList.smoothSandstoneSlab.getSingleSlab(), 0, Blocks.sandstone, BlockSandStone.EnumType.SMOOTH.func_176675_a());
    }

    private void removeVanillaRecipes() {
        removeRecipe(Item.getItemFromBlock(Blocks.stone_slab));

        // Remove Stair recipes
        removeRecipe(Item.getItemFromBlock(Blocks.sandstone_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.stone_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.spruce_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.acacia_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.birch_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.dark_oak_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.jungle_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.oak_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.quartz_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.red_sandstone_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.nether_brick_stairs));
        removeRecipe(Item.getItemFromBlock(Blocks.brick_stairs));
    }

    private void reregisterVanillaRecipes() {
        // Re-register default stairs.
        registerStair(Blocks.stone_stairs, Blocks.cobblestone);
        registerStair(Blocks.spruce_stairs, Blocks.planks, BlockPlanks.EnumType.SPRUCE.func_176839_a());
        registerStair(Blocks.acacia_stairs, Blocks.planks, BlockPlanks.EnumType.ACACIA.func_176839_a());
        registerStair(Blocks.birch_stairs, Blocks.planks, BlockPlanks.EnumType.BIRCH.func_176839_a());
        registerStair(Blocks.dark_oak_stairs, Blocks.planks, BlockPlanks.EnumType.DARK_OAK.func_176839_a());
        registerStair(Blocks.jungle_stairs, Blocks.planks, BlockPlanks.EnumType.JUNGLE.func_176839_a());
        registerStair(Blocks.oak_stairs, Blocks.planks, BlockPlanks.EnumType.OAK.func_176839_a());
        registerStair(Blocks.quartz_stairs, Blocks.quartz_block);
        registerStair(Blocks.red_sandstone_stairs, Blocks.red_sandstone);
        registerStair(Blocks.nether_brick_stairs, Blocks.nether_brick);
        registerStair(Blocks.sandstone_stairs, Blocks.sandstone, BlockSandStone.EnumType.DEFAULT.func_176675_a());

        // Re-register normal slabs.
        registerSlab(Blocks.stone_slab, BlockStoneSlab.EnumType.COBBLESTONE.func_176624_a(), Blocks.cobblestone, 0);
        registerSlab(Blocks.stone_slab, BlockStoneSlab.EnumType.QUARTZ.func_176624_a(), Blocks.quartz_block, 0);
        registerSlab(Blocks.stone_slab, BlockStoneSlab.EnumType.BRICK.func_176624_a(), Blocks.brick_block, 0);
        registerSlab(Blocks.stone_slab, BlockStoneSlab.EnumType.SAND.func_176624_a(), Blocks.sandstone, 0);
        registerSlab(Blocks.stone_slab, BlockStoneSlab.EnumType.STONE.func_176624_a(), Blocks.stone, 0);
        registerSlab(Blocks.stone_slab, BlockStoneSlab.EnumType.SMOOTHBRICK.func_176624_a(), Blocks.stonebrick, 0);
        registerSlab(Blocks.stone_slab, BlockStoneSlab.EnumType.NETHERBRICK.func_176624_a(), Blocks.nether_brick, 0);
    }

    private void removeRecipe(Item item) {
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

    private void registerFence(Block fenceBlock, Block plankBlock, Item stickItem) {
        ItemStack plankBlockStack = new ItemStack(plankBlock, 1, 0);
        ItemStack stickItemStack = new ItemStack(stickItem, 1, 0);
        ItemStack fenceStack = new ItemStack(fenceBlock, 3, 0);
        GameRegistry.addRecipe(fenceStack, "xyx", "xyx", 'x', plankBlockStack, 'y', stickItemStack);
    }

    private void registerStair(Block stairBlock, Block sourceBlock) {
        this.registerStair(stairBlock, sourceBlock, 0);
    }

    private void registerStair(Block stairBlock, Block sourceBlock, int meta) {
        ItemStack sourceItemStack = new ItemStack(sourceBlock, 1, meta);
        ItemStack stairStack = new ItemStack(stairBlock, 6);
        GameRegistry.addRecipe(stairStack, "  x", " xx", "xxx", 'x', sourceItemStack);
    }

    private void registerSlab(Block slabBlock, Block sourceBlock) {
        this.registerSlab(slabBlock, 0, sourceBlock, 0);
    }

    private void registerSlab(Block slabBlock, int slabMeta, Block sourceBlock, int blockMeta) {
        ItemStack sourceItemStack = new ItemStack(sourceBlock, 1, blockMeta);
        ItemStack slabStack = new ItemStack(slabBlock, 6, slabMeta);
        registerSlab(sourceItemStack, slabStack);
    }

    private void registerSlab(ItemStack sourceItemStack, ItemStack slabStack) {
        GameRegistry.addRecipe(slabStack, "xxx", 'x', sourceItemStack);
    }

    private void registerWall(Block wallBlock, Block sourceBlock) {
        this.registerWall(wallBlock, sourceBlock, 0);
    }

    private void registerWall(Block wallBlock, Block sourceBlock, int meta) {
        ItemStack sourceItemStack = new ItemStack(sourceBlock, 1, meta);
        ItemStack wallStack = new ItemStack(wallBlock, 6);
        GameRegistry.addRecipe(wallStack, "xxx", "xxx", 'x', sourceItemStack);
    }
}
