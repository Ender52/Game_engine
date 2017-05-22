package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items;

import java.awt.*;

public class Key extends Item {
    /**
     * <p>The construction of the key</p>
     *
     * @param x       The X coordinate of the key
     * @param y       The Y coordinate of the key
     * @param width   The width of the key
     * @param height  The height of the key
     * @param taken   Tells if the key is in inventory
     * @param equiped Tells if the key is equiped
     */
    public Key(int x, int y, int width, int height, boolean taken, boolean equiped) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.taken = taken;
        this.equiped = equiped;
        color = Color.yellow;
        name = "Key";
    }
}