package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
/**
 * <p>Renders an obstacle</p>
 * 
 * <p>Extends ObjectRenderer</p>
 * 
 */
public class ObstacleRenderer extends ObjectRenderer{
    BufferedImage top, side;
    ImageLoader ilTop, ilSide;
    int h = 100;
    
    public ObstacleRenderer(String path) throws IOException, InterruptedException{
    }
    
    @Override
    public void paintObject(IngameObject io, Graphics g, ImageObserver o) {

        g.setColor(Color.getHSBColor(0.3f, 0.05f, 0.9f));
        g.fillRect(io.x + Game.renderer.windowX, io.y - h + Game.renderer.windowY, io.width, io.height);
        g.setColor(Color.getHSBColor(0.6f, 0.1f, 0.2f));
        g.fillRect(io.x + Game.renderer.windowX, io.y + io.height - h + Game.renderer.windowY, io.width, h);
    }
    
}
