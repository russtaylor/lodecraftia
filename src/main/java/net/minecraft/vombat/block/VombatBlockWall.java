package net.minecraft.vombat.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockWall;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.vombat.VombatMod;
import net.minecraft.world.World;

/**
 * Created by russt on 11/25/14.
 */
public class VombatBlockWall extends BlockWall{
    public VombatBlockWall() {
        super(VombatMod.marbleBlock);
        setCreativeTab(CreativeTabs.tabBlock);
    }

    private IIcon texture;

    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        return texture;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        texture = iconRegister.registerIcon(VombatMod.MOD_ID + ":" + "marble");
    }
}
