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
    public boolean pause = true;
    IngameMenu menu;
    
    public Level() {  //constructor
        color = Color.DARK_GRAY;
        physics = new Physics();
        
        creatures = new ArrayList<>();  //the creatures in a list for comfortable usage

        obstacles = new ArrayList<>();  //the walls in a list for comfortable usage
                
        menus = new ArrayList<>();
    }
    
    public void wPressed(){
        if(!pause){
            player.speedY = -player.speed;
        }else{
            menu.wPressed();
        }
    }
    
    public void sPressed(){
        if(!pause){
            player.speedY = player.speed;
        }else{
            menu.sPressed();
        }
    }
    
    public void aPressed(){
        if(!pause)
            player.speedX = -player.speed;
    }
    
    public void dPressed(){
        if(!pause)
            player.speedX = player.speed;
    }
    
    public void escPressed(){
        pause = !pause;
        pause();
    }
    
    public void enterPressed(){
        if(pause){
            menu.select();
        }
    }

    
    public void wReleased(){
        if(!pause)
            player.speedY = 0;
    }
    
    public void sReleased(){
        if(!pause)
            player.speedY= 0;
    }
    
    public void aReleased(){
        if(!pause)
            player.speedX = 0;
    }
    
    public void dReleased(){
        if(!pause)
            player.speedX = 0;
    }
    
    public void levelLogic(){
    }
    
    public void pause(){
        if(pause){
            menu = new MainMenu(50, 50, WIDTH - 100, HEIGHT - 100);
            menus.add(menu);
        }else{
            menus.remove(menu);
            menu = null;
        }
    }
}
