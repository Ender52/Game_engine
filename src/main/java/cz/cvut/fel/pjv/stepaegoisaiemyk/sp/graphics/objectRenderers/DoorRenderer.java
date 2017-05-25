package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class DoorRenderer extends ObstacleRenderer{
    
    public DoorRenderer(String path) throws IOException, InterruptedException {
        super(path);
    }

    @Override
    public void paintObject(IngameObject io, Graphics g, ImageObserver o) {
        g.setColor(Color.red);
        g.fillRect(io.x + Game.renderer.windowX, io.y - h + Game.renderer.windowY, io.width, io.height);
        g.setColor(Color.red.darker());
        g.fillRect(io.x + Game.renderer.windowX, io.y + io.height - h + Game.renderer.windowY, io.width, h);
    }
    
    
}
