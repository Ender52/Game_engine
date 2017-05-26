package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ImageLoader extends Thread{
    private String path;
    public BufferedImage image;
    public int index;
    
    public ImageLoader(String path, int indexX){
        this.path = path;
        this.index = indexX;
    }
    
    @Override
    public void run(){
        try {
            image = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException ex) {
            Game.new_log.writeToLog("Couldn't read image from given path", "SEVERE");
        }
    }
}
