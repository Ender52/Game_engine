package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics;

import java.awt.Graphics;
import javax.swing.JPanel;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;
     

public class Renderer extends JPanel{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        render(g);
    }
    
    private void render(Graphics g){
        g.setColor(Game.level.color);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for(Creature c : Game.level.creatures){
            g.setColor(c.color);
            g.fillRect(c.x, c.y, c.width, c.height);
        }
        for(Obstacle r : Game.level.obstacles){
            g.setColor(r.color);
            g.fillRect(r.x, r.y, r.width, r.height);
        }
        if(Game.level.menus.size() > 0){
            for(IngameMenu m : Game.level.menus){
                m.repaint(g);
            }
        }
    }
}
