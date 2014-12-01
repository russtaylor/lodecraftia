package net.minecraft.vombat;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.vombat.block.VombatBlock;
import net.minecraft.vombat.block.VombatBlockSlab;
import net.minecraft.vombat.block.VombatBlockWall;
import net.minecraft.vombat.block.VombatItemSlab;
import net.minecraft.vombat.block.VombatStairs;
import net.minecraft.vombat.world.VombatBlockGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = VombatMod.MOD_ID, name = VombatMod.MOD_NAME, version = VombatMod.VERSION)
public class VombatMod
{
    public static final String MOD_ID = "vombat";
    public static final String VERSION = "0.1";
    public static final String MOD_NAME = "Vombat Mod";

    // Blocks
    public static Block marbleBlock;

    // Slabs
    public static Block marbleSlabSingle;
    public static Block marbleSlabDouble;

    // Fence
    public static Block marbleFence;

    // Marble Wall
    public static Block marbleWall;

    // Stairs
    public static Block marbleStairs;

    // World generation
    private VombatBlockGenerator generator = new VombatBlockGenerator();

    @Mod.Instance
    public static VombatMod instance;

    @SidedProxy(clientSide = "net.minecraft.vombat.client.ClientProxy",
            serverSide = "net.minecraft.vombat.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Marble Block
        marbleBlock = new VombatBlock(Material.rock)
                .setHardness(4.0F)
                .setStepSound(Block.soundTypeStone)
                .setCreativeTab(CreativeTabs.tabBlock);
        marbleBlock.setHarvestLevel("pickaxe", 0);

        // Marble Slabs
        marbleSlabSingle = new VombatBlockSlab(false)
                .setHardness(4.0F)
                .setCreativeTab(CreativeTabs.tabBlock);
        marbleSlabSingle.setHarvestLevel("pickaxe", 0);
        marbleSlabDouble = new VombatBlockSlab(true)
                .setHardness(4.0F);
        marbleSlabDouble.setHarvestLevel("pickaxe", 0);

        // Marble Fence
        marbleFence = new BlockFence(Material.rock)
                .setHardness(4.0F)
                .setCreativeTab(CreativeTabs.tabBlock);
        marbleFence.setHarvestLevel("pickaxe", 0);

        // Marble Wall
        marbleWall = new VombatBlockWall()
                .setHardness(4.0F);
        marbleWall.setHarvestLevel("pickaxe", 0);

        // Marble Stairs
        marbleStairs = new VombatStairs(marbleBlock)
                .setHardness(4.0F)
                .setStepSound(Block.soundTypeStone)
                .setCreativeTab(CreativeTabs.tabBlock);

        GameRegistry.registerBlock(marbleBlock, "Marble");
        GameRegistry.registerBlock(marbleSlabSingle, VombatItemSlab.class, "marble-slab-single");
        GameRegistry.registerBlock(marbleSlabDouble, VombatItemSlab.class, "marble-slab-double");
        GameRegistry.registerBlock(marbleFence, "marble-fence");
        GameRegistry.registerBlock(marbleWall, "marble-wall");
        GameRegistry.registerBlock(marbleStairs, "marble-stairs");

        // Add recipes
        ItemStack marbleSlabStack = new ItemStack(marbleSlabSingle, 6);
        ItemStack marbleBlockStack = new ItemStack(marbleBlock);
        GameRegistry.addRecipe(marbleSlabStack, "mmm", 'm', marbleBlockStack);

        GameRegistry.registerWorldGenerator(generator, 50);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }
}
