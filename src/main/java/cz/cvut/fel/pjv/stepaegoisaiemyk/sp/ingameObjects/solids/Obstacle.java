package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import java.awt.Color;

public class Obstacle extends Solid {
    public Color color = Color.LIGHT_GRAY;

    /**
     * <p>The construction of the obstacle</p>
     *
     * @param x      The X coordinate of the obstacle
     * @param y      The Y coordinate of the obstacle
     * @param width  The width of the obstacle
     * @param height The height of the obstacle
     */
    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        weight = 10000;
    }

}
