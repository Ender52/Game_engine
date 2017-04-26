package semestralproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Level implements ActionListener, KeyListener{
    final int HEIGHT = 500, WIDTH = 500;  //variables changing size of the frame; used everyewhere
    Color color;
    Creature player;
    Physics physics;
    ArrayList<Obstacle> obstacles;
    ArrayList<Creature> creatures;
    ArrayList<IngameMenu> menus;
    int time = 0;
    int loop = 1;
    Timer timer;
    boolean pause = true;
    IngameMenu menu;
    
    public Level() {  //constructor
        color = Color.DARK_GRAY;
        physics = new Physics();
        timer = new Timer(10, this);  //a timer here
        
        creatures = new ArrayList<>();  //the creatures in a list for comfortable usage

        obstacles = new ArrayList<>();  //the walls in a list for comfortable usage
                
        menus = new ArrayList<>();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  //plays all the animations and calls the repaint whenever the timer ticks
        if(pause){
            pauseMenu();
        }
        physics.run();
        Start.renderer.repaint(0, 0, Start.WIDTH, Start.HEIGHT); 
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {  //changes the movement vector whenever one of the keys is pressed
        if(e.getKeyCode() == KeyEvent.VK_W && !pause){  //up
            player.speedY = -player.speed;
        }
        if(e.getKeyCode() == KeyEvent.VK_S && !pause){  //down
            player.speedY = player.speed;
        }
        if(e.getKeyCode() == KeyEvent.VK_A && !pause){  //left
            player.speedX = -player.speed;
        }
        if(e.getKeyCode() == KeyEvent.VK_D && !pause){  //right
            player.speedX = player.speed;
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            if(!pause){
                Start.pause();
                pause = true;
            }else{
                Start.resume();
                pause = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {  //this enables diagonal walking
        if(e.getKeyCode() == KeyEvent.VK_W){  //up
            player.speedY = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){  //down
            player.speedY= 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_A){  //left
            player.speedX = 0;
        }
        if(e.getKeyCode() == KeyEvent.VK_D){  //right
            player.speedX = 0;
        }
    }
    
    public void repaint(Graphics g){  //refreshes the frame
        g.setColor(color);
        g.fillRect(0, 0, Start.WIDTH, Start.HEIGHT);
        for(Creature c : Start.level.creatures){
            g.setColor(c.color);
            g.fillRect(c.x, c.y, c.width, c.height);
        }
        for(Obstacle r : obstacles){
            g.setColor(r.color);
            g.fillRect(r.x, r.y, r.width, r.height);
        }
        if(menus.size() > 0){
            for(IngameMenu m : menus){
                m.repaint(g);
            }
        }
        
    }
    
    public void pauseMenu(){
        Start.frame.removeKeyListener(this);
        menu = new MainMenu(Start.WIDTH / 4, 20, (2*Start.WIDTH) / 4, Start.HEIGHT - 40);
        menus.add(menu);
    }
    
    public void levelLogic(){
        pauseMenu();
    }
    
    public void turnOff(){
        obstacles.clear();
        creatures.clear();
        menus.clear();
        Start.frame.removeKeyListener(this);
        //timer.stop();
    }
}
