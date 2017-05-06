package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics;

import java.awt.Graphics;
import javax.swing.JPanel;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
     

public class Renderer extends JPanel{
    int windowX, windowY, realtime = 0, framecount = 0, fps = 0;
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        render(g);
    }
    
    private void render(Graphics g){
        framecount++;
        windowX = -Game.level.player.x + Game.WIDTH/2 - 20;
        windowY = -Game.level.player.y + Game.HEIGHT/2 - 20;
        g.setColor(Game.level.color);
        g.fillRect(windowX, windowY, Game.WIDTH, Game.HEIGHT);
        for(Creature c : Game.level.creatures){
            g.setColor(c.color);
            g.fillRect(windowX + c.x, windowY + c.y, c.width, c.height);
        }
        for(Obstacle r : Game.level.obstacles){
            g.setColor(r.color);
            g.fillRect(windowX + r.x, windowY + r.y, r.width, r.height);
        }
        if(Game.level.menus.size() > 0){
            for(IngameMenu m : Game.level.menus){
                menuRender(m, g);
            }
        }
        /* Monitoring FPS */
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        String s = sdf.format(cal.getTime());
        if(Integer.valueOf(s) > realtime){
            fps = framecount;
            framecount = 0;
            realtime = Integer.valueOf(s);
        }
        g.setFont(new Font("Arial", 1, 10));
        g.setColor(Color.red);
        g.drawString("FPS: " + fps, 5, 15);
        g.drawString("Number of objects: " + Game.level.obstacles.size(), 5, 30);
        /**/
    }
    
    public void menuRender(IngameMenu m, Graphics g) {
        g.setColor(m.color);
        g.fillRect(m.x, m.y, m.width, m.height);
        for(IngameButton b : m.buttons){
            g.setColor(b.color);
            if(b.positionInList == m.position){
                g.setColor(b.activeColor);
            }
            g.fillRect(b.x, b.y, b.width, b.height);
            g.setColor(b.fontColor);
            if(b.positionInList == m.position){
                g.setColor(b.fontColorActive);
            }
            g.setFont(b.font);
            g.drawString(b.name, b.fontX, b.fontY);
        }
    }
}
