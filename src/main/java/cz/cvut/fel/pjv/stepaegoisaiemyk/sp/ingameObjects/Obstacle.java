package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects;

import java.awt.Color;

public class Obstacle extends Solid {
    public Color color = Color.LIGHT_GRAY;

    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        weight = 10000;
    }

}
