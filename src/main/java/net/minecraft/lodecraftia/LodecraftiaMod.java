package net.minecraft.lodecraftia;

import net.minecraft.lodecraftia.block.BlockHandler;
import net.minecraft.lodecraftia.world.VombatBlockGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LodecraftiaMod.MOD_ID, name = LodecraftiaMod.MOD_NAME, version = LodecraftiaMod.VERSION)
public class LodecraftiaMod
{
    public static final String MOD_ID = "lodecraftia";
    public static final String VERSION = "0.1";
    public static final String MOD_NAME = "Vombat Mod";

    // Blocks
    public static BlockHandler blockHandler = new BlockHandler();

    // World generation
    private VombatBlockGenerator generator = new VombatBlockGenerator();

    @Mod.Instance
    public static LodecraftiaMod instance;

    @SidedProxy(clientSide = "net.minecraft.lodecraftia.client.ClientProxy",
            serverSide = "net.minecraft.lodecraftia.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        blockHandler.registerBlocks();
        GameRegistry.registerWorldGenerator(generator, 50);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }
}
