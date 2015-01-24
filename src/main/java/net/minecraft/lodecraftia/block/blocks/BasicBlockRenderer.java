package net.minecraft.lodecraftia.block.blocks;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

/**
 * Custom renderer.
 *
 * Created by russt on 1/8/15.
 */
public class BasicBlockRenderer extends TileEntitySpecialRenderer {
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int i) {
        Tessellator tessellator = Tessellator.getInstance();

        this.bindTexture(TextureMap.locationBlocksTexture);

        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);

        tessellator.getWorldRenderer().startDrawingQuads();
        tessellator.getWorldRenderer().addVertexWithUV(0, 0, 0, 0, 0);
        tessellator.getWorldRenderer().addVertexWithUV(0, 1, 0, 0, 1);
        tessellator.getWorldRenderer().addVertexWithUV(1, 1, 0, 1, 1);
        tessellator.getWorldRenderer().addVertexWithUV(1, 0, 0, 1, 0);

        tessellator.getWorldRenderer().addVertexWithUV(0, 0, 0, 0, 0);
        tessellator.getWorldRenderer().addVertexWithUV(1, 0, 0, 1, 0);
        tessellator.getWorldRenderer().addVertexWithUV(1, 1, 0, 1, 1);
        tessellator.getWorldRenderer().addVertexWithUV(0, 1, 0, 0, 1);

        tessellator.getWorldRenderer().draw();
        GL11.glPopMatrix();
    }
}
