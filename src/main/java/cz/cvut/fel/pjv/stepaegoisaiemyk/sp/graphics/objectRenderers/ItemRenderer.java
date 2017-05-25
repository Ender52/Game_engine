package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemRenderer extends ObjectRenderer{
    BufferedImage image;
    ImageLoader il;
    
    public ItemRenderer(String path){
        il = new ImageLoader(path + "icon.png", 0);
    }

    @Override
    public void paintObject(IngameObject io, Graphics g, ImageObserver o) {
        /*if(image == null){
            try {
                il.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(ItemRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
            image = il.image;
        }
        g.drawImage(image, io.x + Game.renderer.windowX, io.y + Game.renderer.windowY, o);*/
        g.setColor(Color.yellow);
        g.fillRect(io.x + Game.renderer.windowX, io.y + Game.renderer.windowY, io.width, io.height);
        
    }
    
}
