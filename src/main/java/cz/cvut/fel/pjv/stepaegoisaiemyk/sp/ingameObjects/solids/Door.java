package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers.DoorRenderer;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Obstacle;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            or = new DoorRenderer(path);
        } catch (IOException ex) {
            Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
