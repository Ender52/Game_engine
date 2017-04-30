package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.physics.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Level{
    final int HEIGHT = 500, WIDTH = 500;  //variables changing size of the frame; used everyewhere
    public Color color;
    Creature player;
    Physics physics;
    public ArrayList<Obstacle> obstacles;
    public ArrayList<Creature> creatures;
    public ArrayList<IngameMenu> menus;
    int loop = 1;
    public int time = 0;
    //public Timer timer;
    boolean pause = true;
    IngameMenu menu;
    
    public Level() {  //constructor
        color = Color.DARK_GRAY;
        physics = new Physics();
        
        creatures = new ArrayList<>();  //the creatures in a list for comfortable usage

        obstacles = new ArrayList<>();  //the walls in a list for comfortable usage
                
        menus = new ArrayList<>();
    }
    
    public void wPressed(){
        player.speedY = -player.speed;
    }
    
    public void sPressed(){
        player.speedY = player.speed;
    }
    
    public void aPressed(){
        player.speedX = -player.speed;
    }
    
    public void dPressed(){
        player.speedX = player.speed;
    }

    
    public void wReleased(){
        player.speedY = 0;
    }
    
    public void sReleased(){
        player.speedY= 0;
    }
    
    public void aReleased(){
        player.speedX = 0;
    }
    
    public void dReleased(){
        player.speedX = 0;
    }

    public void repaint(Graphics g){  //refreshes the frame
        g.setColor(color);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        for(Creature c : Game.level.creatures){
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
    
    public void levelLogic(){
        //pauseMenu();
    }

}
