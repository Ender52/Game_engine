package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Obstacle;

import java.awt.*;

public class Door extends Obstacle {
    /**
     * <p>The construction of the door</p>
     *
     * @param x      The X coordinate of the door
     * @param y      The Y coordinate of the door
     * @param width  The width of the door
     * @param height The height of the door
     */
    public Door(int x, int y, int width, int height) {
        super(x, y, width, height);
        color = Color.RED;
    }
}
