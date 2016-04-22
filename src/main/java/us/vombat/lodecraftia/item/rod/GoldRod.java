package us.vombat.lodecraftia.item.rod;

import us.vombat.lodecraftia.item.ModItem;

/**
 * Gold rods.
 *
 * Created by russt on 12/22/14.
 */
public class GoldRod extends ModItem {

    public static final String ITEM_NAME = "gold-rod";

    public GoldRod() {
        super(ITEM_NAME);
    }

    public ModItem register() {
        return register(ITEM_NAME);
    }
}
