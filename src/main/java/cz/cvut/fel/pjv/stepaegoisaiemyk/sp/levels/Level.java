package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.physics.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.*;

import java.awt.Color;
import java.util.ArrayList;


public class Level{
    final int HEIGHT = Game.HEIGHT, WIDTH = Game.WIDTH;  //variables changing size of the frame; used everyewhere
    public Color color;
    public Player player;
    Physics physics;
    public ArrayList<Obstacle> obstacles;
    public ArrayList<Creature> creatures;
    public ArrayList<IngameMenu> menus;
    public ArrayList<Item> items;
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

        items = new ArrayList<>(); //items on the floor
        
        menus = new ArrayList<>();
    }
    
    public void wPressed(){
        if(!pause){
            player.speedY = -player.speed;
            player.direction = 0;
        }else{
            menu.wPressed();
        }
    }
    
    public void sPressed(){
        if(!pause){
            player.speedY = player.speed;
            player.direction = 2;
        }else{
            menu.sPressed();
        }
    }
    
    public void aPressed(){
        if(!pause){
            player.speedX = -player.speed;
            player.direction = 3;
        }
    }
    
    public void dPressed(){
        if(!pause){
            player.speedX = player.speed;
            player.direction = 1;
        }
    }
    
    public void escPressed(){
        pause = !pause;
        pause();
    }

    public void iPressed(){
        pause = !pause;
        open_inventory();
    }
    
    public void enterPressed(){
        if(pause){
            menu.select();
        }
    }
    
    public void spacePressed(){
        if(!pause){
            player.charging();
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
    
    public void spaceReleased(){
        if(!pause){
            if(player.charge > 5 && player.speedX == 0 && player.speedY == 0){
                player.heavyAttack();
            }else{
                player.simpleAttack();
            }
            player.charge = 0;
        }
    }

    public void Item_picked()
    {
        for (Item i : items)
        {
            if(i.intersects(player) && !i.taken)
            {
                i.taken = true;
                System.out.println("item is being picked");
                player.inventory.add(i);
            }
        }
    }
    
    public void levelLogic(){
        pause();
    }

    public void open_inventory(){
        if(pause){
           menu = new InventoryMenu(100,100, WIDTH - 200, 330);
           menus.add(menu);
        }else{
            menus.remove(menu);
            menu = null;
        }
    }

    public void pause(){
        if(pause){
            menu = new MainMenu(300, 100, WIDTH - 600, HEIGHT - 200);
            menus.add(menu);
        }else{
            menus.remove(menu);
            menu = null;
        }
    }
}
