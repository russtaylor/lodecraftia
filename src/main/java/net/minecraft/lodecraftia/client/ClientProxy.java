package net.minecraft.lodecraftia.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.lodecraftia.CommonProxy;
import net.minecraft.lodecraftia.LodecraftiaMod;
import net.minecraft.lodecraftia.block.BlockList;
import net.minecraft.lodecraftia.block.ModBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * A proxy to handle registering the renderers for the blocks we have.
 *
 * Created by russt on 11/21/14.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        for (ModBlock block : BlockList.blockList) {
            Item item = GameRegistry.findItem(LodecraftiaMod.MOD_ID, block.getBlockName());
            registerBlockRenderer(item, LodecraftiaMod.MOD_ID + ":" + block.getBlockName());
        }
    }

    public void registerBlockRenderer(Item item, int metadata, String itemName) {
        ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        mesher.register(item, metadata, new ModelResourceLocation(itemName, "inventory"));
    }

    public void registerBlockRenderer(Item item, String itemName) {
        registerBlockRenderer(item, 0, itemName);
    }
}
