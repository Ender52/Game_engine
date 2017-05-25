package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObstacleRenderer extends ObjectRenderer{
    BufferedImage top, side;
    ImageLoader ilTop, ilSide;
    
    public ObstacleRenderer(String path) throws IOException, InterruptedException{
        /*ImageLoader ilTop = new ImageLoader(path + "top.png");
        ImageLoader ilSide = new ImageLoader(path + "side.png");
        ilTop.join();
        ilSide.join();
        top = ilTop.image;
        side = ilSide.image;*/
    }
    
    @Override
    public void paintObject(IngameObject io, Graphics g, ImageObserver o) {
        /*if(top == null){
            try {
                ilTop.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ItemRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
            top = ilTop.image;
        }
        if(side == null){
            try {
                ilSide.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ItemRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
            side = ilSide.image;
        }
        g.drawImage(top, io.x, io.y - 60, io.width, io.height, o);
        g.drawImage(side, io.x, io.y + io.height - 60, io.width, 60, o);*/
        g.setColor(Color.white);
        g.fillRect(io.x + Game.renderer.windowX, io.y - 60 + Game.renderer.windowY, io.width, io.height);
        g.setColor(Color.GRAY);
        g.fillRect(io.x + Game.renderer.windowX, io.y + io.height - 60 + Game.renderer.windowY, io.width, 60);
    }
    
}
