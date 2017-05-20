package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics;

import java.awt.Graphics;
import javax.swing.JPanel;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
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
        windowX = -Game.level.player.x + (Game.WIDTH/2 - 20);
        windowY = -Game.level.player.y + (Game.HEIGHT/2 - 20);
        g.setColor(Game.level.color);
        //background
        g.fillRect((int)(windowX ), (int)(windowY), Game.WIDTH, Game.HEIGHT);
        
        //testing
        g.setColor(Color.red);
        Rectangle rect = Game.level.player.simpleAttackRanges.get(Game.level.player.direction);
        g.fillRect(windowX + rect.x, windowY + rect.y, rect.width, rect.height);
        
        //middleground
        for(Creature c : Game.level.creatures){
            //if(!c.alive){
            //    continue;
            //}
            g.setColor(c.color);
            g.fillRect(windowX + c.x, windowY + c.y, c.width, c.height);
        }

        //items
        for(Item i : Game.level.items){
            g.setColor(i.color);
            g.fillRect(windowX + i.x, windowY + i.y, i.width, i.height);
        }
        
        for(Obstacle r : Game.level.obstacles){
            g.setColor(r.color);
            g.fillRect(windowX + r.x, windowY + r.y, r.width, r.height);
        }
        //UI
        for(IngameMenu m : Game.level.menus){
            menuRender(m, g);
        }
        
        /* Monitoring FPS */
        framecount++;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        String s = sdf.format(cal.getTime());
        if(Integer.valueOf(s) != realtime){
            fps = framecount;
            framecount = 0;
            realtime = Integer.valueOf(s);
        }
        g.setFont(new Font("Arial", 1, 10));
        g.setColor(Color.red);
        g.drawString("FPS: " + fps, 5, 15);
        g.drawString("Number of obstacles: " + Game.level.obstacles.size(), 5, 30);
        g.drawString("Number of creatures: " + Game.level.creatures.size(), 5, 45);
        g.drawString("Charging: " + Game.level.player.charge, 5, 60);
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
