package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 * <p>Renders an item</p>
 * 
 * <p>Extends ObjectRenderer</p>
 * 
 */
public class ItemRenderer extends ObjectRenderer{
    BufferedImage image;
    ImageLoader il;
    
    public ItemRenderer(String path){
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/icon.png"));
        } catch (IOException ex) {
            //Logger.getLogger(ItemRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintObject(IngameObject io, Graphics g, ImageObserver o) {
        g.drawImage(image, io.x + Game.renderer.windowX, io.y + Game.renderer.windowY,image.getWidth(),image.getHeight(), o);
        /*g.setColor(Color.yellow);
        g.fillRect(io.x + Game.renderer.windowX, io.y + Game.renderer.windowY, io.width, io.height);*/
        
    }
    
}
