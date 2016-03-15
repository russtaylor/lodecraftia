package net.minecraft.lodecraftia;

import net.minecraft.lodecraftia.block.BlockHandler;
import net.minecraft.lodecraftia.item.ItemHandler;
import net.minecraft.lodecraftia.recipe.RecipeHandler;
import net.minecraft.lodecraftia.world.ModBlockGenerator;
import net.minecraft.lodecraftia.world.ModWorldGenerator;
import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LodecraftiaMod.MOD_ID, name = LodecraftiaMod.MOD_NAME, version = LodecraftiaMod.VERSION)
public class LodecraftiaMod
{
    public static final String MOD_ID = "lodecraftia";
    public static final String VERSION = "0.1";
    public static final String MOD_NAME = "Lodecraftia";

    // World
    public static World world;
    public static long worldSeed;
    public static ModWorldGenerator worldGenerator;

    // Blocks
    public static BlockHandler blockHandler = new BlockHandler();

    // Items
    public static ItemHandler itemHandler = new ItemHandler();

    // Recipes
    public static RecipeHandler recipeHandler = new RecipeHandler();

    // World generation
    private ModBlockGenerator generator = new ModBlockGenerator();

    @Mod.Instance
    public static LodecraftiaMod instance;

    @SidedProxy(clientSide = "net.minecraft.lodecraftia.client.ClientProxy",
            serverSide = "net.minecraft.lodecraftia.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        blockHandler.registerBlocks();
        itemHandler.registerItems();
        recipeHandler.registerRecipes();
        GameRegistry.registerWorldGenerator(generator, 50);
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        world = event.world;
        worldSeed = world.getSeed();
        worldGenerator = new ModWorldGenerator(
                worldSeed,
                world.getWorldInfo().getTerrainType(),
                world.getWorldInfo().getGeneratorOptions());
    }

}
