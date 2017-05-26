package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;

import java.awt.image.BufferedImage;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
/**
 * <p>Renders a creature, static poses and animation</p>
 * 
 * <p>Extends ObjectRenderer</p>
 * 
 */
public class CreatureRenderer extends ObjectRenderer {
    public BufferedImage[] standing, walkingFront, walkingRight, walkingBack, walkingLeft;
    BufferedImage shadow;
    BufferedImage[][] arr;
    int counter = 0;

    /**
     * <p>The construction of creature renderer</p>
     *
     * @param path The path to images for creature
     */
    public CreatureRenderer(String path) throws IOException, InterruptedException {
        shadow = ImageIO.read(getClass().getResourceAsStream(path + "/shadow.png"));
        standing = loadSequence(path, 4);
        walkingFront = loadSequence(path + "/walkingFront", 50);
        walkingRight = loadSequence(path + "/walkingRight", 50);
        walkingBack = loadSequence(path + "/walkingBack", 50);
        walkingLeft = loadSequence(path + "/walkingLeft", 50);
        arr = new BufferedImage[4][50];
        arr[0] = walkingBack;
        arr[1] = walkingRight;
        arr[2] = walkingFront;
        arr[3] = walkingLeft;
    }

    /**
     * <p>The painting of the creature</p>
     *
     * @param c The creature, that will be painted
     * @param g The graphics, that will be used
     * @param o The imageobserver
     */
    public void paintCreature(Creature c, Graphics g, ImageObserver o) throws InterruptedException {
        BufferedImage n = shadow;
        g.drawImage(n, c.x + Game.renderer.windowX - (n.getWidth() - c.width) / 2, c.y + Game.renderer.windowY - (n.getHeight() - c.height) + 15, o);
        BufferedImage i;
        if (c.speedX == 0 && c.speedY == 0) {
            i = standing[c.direction];
        } else {
            i = arr[c.direction][c.frame];
        }
        if(c.rangeVisible){
            counter++;
            g.setColor(Color.red);
            g.fillRect(c.simpleAttackRanges.get(c.direction).x+ Game.renderer.windowX, c.simpleAttackRanges.get(c.direction).y+ Game.renderer.windowY, c.simpleAttackRanges.get(c.direction).width, c.simpleAttackRanges.get(c.direction).height);
            if(counter > 15){
                c.rangeVisible = false;
                counter = 0;
            }
        }
        g.drawImage(i, c.x + Game.renderer.windowX - (i.getWidth() - c.width) / 2, c.y + Game.renderer.windowY - (i.getHeight() - c.height) + 15, o);
    }

    private BufferedImage[] loadSequence(String path, int quantity) throws InterruptedException {
        BufferedImage[] ret = new BufferedImage[quantity];
        ArrayList<ImageLoader> ils = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            ImageLoader l = new ImageLoader(path + String.format("/0001(%d)", i + 1) + ".png", i);
            l.start();
            ils.add(l);
        }
        waitForThreads(ils, ret);
        return ret;
    }

    private void waitForThreads(ArrayList<ImageLoader> threads, BufferedImage[] buffer) throws InterruptedException {
        for (ImageLoader l : threads) {
            l.join();
            buffer[l.index] = l.image;
        }
    }

    @Override
    public void paintObject(IngameObject io, Graphics g, ImageObserver o) {
        try {
            paintCreature((Creature) io, g, o);
        } catch (InterruptedException ex) {
            Game.new_log.writeToLog("Thread fail", "SEVERE");
        }
    }
}
