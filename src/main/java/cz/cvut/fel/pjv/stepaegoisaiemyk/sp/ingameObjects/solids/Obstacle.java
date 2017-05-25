package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers.ObstacleRenderer;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Obstacle extends Solid {
    public Color color = Color.LIGHT_GRAY;
    public String path = "/sprites/obstacles";

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
        try {
            or = new ObstacleRenderer(path);
        } catch (IOException ex) {
            Logger.getLogger(Obstacle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Obstacle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
