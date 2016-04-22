package us.vombat.lodecraftia.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import us.vombat.lodecraftia.CommonProxy;
import us.vombat.lodecraftia.LodecraftiaMod;
import us.vombat.lodecraftia.block.BlockList;
import us.vombat.lodecraftia.block.IModBlock;
import us.vombat.lodecraftia.item.IModItem;
import us.vombat.lodecraftia.item.ItemList;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * A proxy to handle registering the renderers for the blocks we have.
 *
 * Created by russt on 11/21/14.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        for (IModBlock block : BlockList.blockList) {
            Item item = GameRegistry.findItem(LodecraftiaMod.MOD_ID, block.getBlockName());
            registerBlockRenderer(item, LodecraftiaMod.MOD_ID + ":" + block.getBlockName());
        }

        for (IModItem item : ItemList.itemList) {
            Item gameItem = GameRegistry.findItem(LodecraftiaMod.MOD_ID, item.getItemName());
            registerBlockRenderer(gameItem, LodecraftiaMod.MOD_ID + ":" + item.getItemName());
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
