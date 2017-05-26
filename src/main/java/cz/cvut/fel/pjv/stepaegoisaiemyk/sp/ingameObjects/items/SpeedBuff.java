package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items;

import java.awt.*;

public class SpeedBuff extends Item {
    /**
     * <p>The construction of the Speed buff</p>
     *
     * @param x       The X coordinate of the buff
     * @param y       The Y coordinate of the buff
     * @param width   The width of the buff
     * @param height  The height of the buff
     * @param taken   Tells if the buff is in inventory
     * @param equiped Tells if the buff is equiped
     */
    public SpeedBuff(int x, int y, int width, int height, boolean taken, boolean equiped) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.taken = taken;
        this.equiped = equiped;
        color = Color.green;
        name = "Speed buff";
    }
}