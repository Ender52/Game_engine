package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.physics;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.*;

import java.awt.Rectangle;

public class Physics {
    
    public void run(){
        if(Game.level.pause){
            return;
        }
        Game.level.levelLogic();
        for(Creature c : Game.level.creatures){
            int x = 0, y = 0;
            if(c.active && collision(c)){
                if(collision(c.sencorT)){
                    y += 1;
                }
                if(collision(c.sencorB)){
                    y += -1;
                }
                if(collision(c.sencorR)){
                    x += -1;
                }
                if(collision(c.sencorL)){
                    x += 1;
                }
            }
            move(c, c.speedX, c.speedY, c.speed);
            react(c, x, y);
        }
    }
    
    private boolean collision(Rectangle o){
        for(Obstacle r: Game.level.obstacles){
            if(r.intersects(o)){
                return true;
            }
        }
        return false;
    }
    
    public void move(Creature r, int x, int y, int speed){  //changes the position of the player
        if((x == 0 && y == 0) || !r.active){
            return;
        }
        int i = 0;
        r.x += x;
        r.y += y;
        while(collision(r) && i != speed){
            r.x -= x/speed;
            r.y -= y/speed;
            i++;
        }
        r.reloc(r.x, r.y);
    }
    
    public void react(Creature r, int x, int y){
        if((x == 0 && y == 0) || !r.active){
            return;
        }
        while(collision(r)){
            r.x += x;
            r.y += y;
        }
        r.reloc(r.x, r.y);
    }
}
