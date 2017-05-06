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
                menuRender(m, g);
            }
        }
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
