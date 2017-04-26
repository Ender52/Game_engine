package semestralproject;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class IngameMenu extends Rectangle implements KeyListener{
    Color color;
    public ArrayList<IngameButton> buttons;
    int position = 0;
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("MENU W...");
            position ++;
            position = Math.abs((position )% buttons.size());
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("MENU S...");
            position --;
            position = Math.abs((position )% buttons.size());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public IngameMenu(int x, int y, int width, int height){
        super(x, y, width, height);
        buttons = new ArrayList<>();
        Start.frame.addKeyListener(this);
    }

    public void repaint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        for(IngameButton b : buttons){
            g.setColor(b.color);
            if(b.positionInList == position){
                g.setColor(b.activeColor);
            }
            g.fillRect(b.x, b.y, b.width, b.height);
            g.setColor(b.fontColor);
            if(b.positionInList == position){
                g.setColor(b.fontColorActive);
            }
            g.setFont(b.font);
            g.drawString(b.name, b.fontX, b.fontY);
        }
    }
    
}

