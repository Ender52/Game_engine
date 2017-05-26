package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics;

import java.awt.Graphics;
import javax.swing.JPanel;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.IngameObject;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.IngameButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import javax.imageio.ImageIO;

/**
 * <p>The renderer class is responible for the graphical representation of all the elements in the game</p>
 * <p>It renders all objects on the level and all UI elements including pause menus</p>
 * <p>It is called every "tick"</p>
 * <p>
 * <p>Also contains some testing constractions such as FPS counter</p>
 */
public class Renderer extends JPanel {
    public int windowX, windowY, realtime = 0, framecount = 0, fps = 0;
    BufferedImage background;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (Game.level.player != null) {
            windowX = -Game.level.player.x + (Game.WIDTH / 2 - 20);
            windowY = -Game.level.player.y + (Game.HEIGHT / 2 - 20);
        }
        ArrayList<IngameObject> sceneObjects = new ArrayList<>();
        sceneObjects.addAll(Game.level.creatures);
        sceneObjects.addAll(Game.level.items);
        sceneObjects.addAll(Game.level.obstacles);
        if (Game.level.player != null && background == null) {
            System.out.println("Updating background");
            try {
                //background
                BufferedImage before = ImageIO.read(getClass().getResourceAsStream("/background/map1_alpha.png"));
                int w = before.getWidth();
                int h = before.getHeight();
                background = new BufferedImage(w * 3, h * 3, BufferedImage.TYPE_INT_ARGB);
                AffineTransform at = new AffineTransform();
                at.scale(3.0, 3.0);
                AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
                background = scaleOp.filter(before, background);
            } catch (IOException ex) {
                Game.new_log.writeToLog("Couldn't load background", "INFO");
            }
        }
        if (background != null) {
            g.drawImage(background, windowX, windowY, background.getWidth(), background.getHeight(), this);
        }

        Collections.sort(sceneObjects, new Comparator<IngameObject>() {
            @Override
            public int compare(IngameObject o1, IngameObject o2) {
                return (o1.y + o1.height) - (o2.y + o2.height);
            }
        });

        for (IngameObject io : sceneObjects) {
            io.or.paintObject(io, g, this);
        }
        if (Game.level.player != null) {
            g.setColor(Color.black);
            g.fillRect(Game.WIDTH - 310, Game.HEIGHT - 25, 300, 15);
            g.setColor(Color.red);
            g.fillRect(Game.WIDTH - 308 + (100 - Game.level.player.health) * 3, Game.HEIGHT - 23, Game.level.player.health * 3 - 3, 11);
        }

        //UI
        for (IngameMenu m : Game.level.menus) {
            menuRender(m, g);
        }
        
        /* Monitoring FPS */
        framecount++;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        String s = sdf.format(cal.getTime());
        if (Integer.valueOf(s) != realtime) {
            fps = framecount;
            framecount = 0;
            realtime = Integer.valueOf(s);
        }
        g.setFont(new Font("Arial", 1, 10));
        g.setColor(Color.red);
        g.drawString("FPS: " + fps, 5, 15);
        g.drawString("Number of obstacles: " + Game.level.obstacles.size(), 5, 30);
        g.drawString("Number of creatures: " + Game.level.creatures.size(), 5, 45);
        if (Game.level.player != null) {
            g.drawString("Charging: " + Game.level.player.charge, 5, 60);
        }
        /**/
    }

    private void menuRender(IngameMenu m, Graphics g) {
        g.setColor(m.color);
        g.fillRect(m.x, m.y, m.width, m.height);
        for (IngameButton b : m.buttons) {
            g.setColor(b.color);
            if (b.positionInList == m.position) {
                g.setColor(b.activeColor);
            }
            g.fillRect(b.x, b.y, b.width, b.height);
            g.setColor(b.fontColor);
            if (b.positionInList == m.position) {
                g.setColor(b.fontColorActive);
            }
            g.setFont(b.font);
            g.drawString(b.name, b.fontX, b.fontY);
        }
    }
}
