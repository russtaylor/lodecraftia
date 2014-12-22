package net.minecraft.lodecraftia.item.rod;

import net.minecraft.lodecraftia.item.ModItem;

/**
 * Iron rods.
 *
 * Created by russt on 12/22/14.
 */
public class IronRod extends ModItem {

    public static final String ITEM_NAME = "iron-rod";

    public IronRod() {
        super(ITEM_NAME);
    }

    public ModItem register() {
        return register(ITEM_NAME);
    }
}
