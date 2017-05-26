package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers.ObstacleRenderer;
import java.awt.Color;
import java.io.IOException;
/**
 * <p>A class that defines every wall or other immovable object on the level</p>
 * 
 */
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
            Game.new_log.writeToLog("Couldn't read obstacle from given path", "SEVERE");
        } catch (InterruptedException ex) {
            Game.new_log.writeToLog("Thread fail", "SEVERE");
        }
    }
}
