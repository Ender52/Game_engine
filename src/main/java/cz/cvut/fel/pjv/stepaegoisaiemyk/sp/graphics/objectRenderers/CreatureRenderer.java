package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import java.awt.image.BufferedImage;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Solid;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;

public class CreatureRenderer extends ObjectRenderer{
    public ArrayList<BufferedImage> standing, walkingFront, walkingRight, walkingBack, walkingLeft;
    
    public CreatureRenderer(String path) throws IOException, InterruptedException{
        standing = loadSequence(path, 4);
        /*walkingFront = loadSequence(path + "/walkingFront", 50);
        walkingRight = loadSequence(path + "/walkingRight", 50);
        walkingBack = loadSequence(path + "/walkingBack", 50);
        walkingLeft = loadSequence(path + "/walkingLeft", 50);*/
    }
    
    public void paintCreature(Creature c, Graphics g, ImageObserver o){
        BufferedImage i = standing.get(c.direction);
        g.drawImage(i, c.x + Game.renderer.windowX - (i.getWidth() - c.width)/2, c.y + Game.renderer.windowY - (i.getHeight() - c.height), o);
    }
    
    private ArrayList<BufferedImage> loadSequence(String path, int quantity) throws InterruptedException{
        ArrayList<BufferedImage> ret = new ArrayList<>();
        ArrayList<ImageLoader> ils = new ArrayList<>();
            for(int i = 0; i < quantity; i++){
                    ImageLoader il = new ImageLoader(path + String.format("/%04d", i+1) + ".png");
                    il.start();
                    ils.add(il);
            }
            waitForThreads(ils, ret);
        return ret;
    }
    
    private void waitForThreads(ArrayList<ImageLoader> threads, ArrayList<BufferedImage> buffer) throws InterruptedException{
        for(ImageLoader il : threads){
            il.join();
            buffer.add(il.image);
        }
    }

    @Override
    public void paintObject(IngameObject io, Graphics g, ImageObserver o) {
        paintCreature((Creature) io, g, o);
    }
}
