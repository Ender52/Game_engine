package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;

public class Player extends Creature{
    public ArrayList<Rectangle> simpleAttackRanges;
    public int range = 10;
    public int direction;
    
    public Player(int x, int y, int width, int height, int speed, boolean active, int weight) {
        super(x, y, width, height, speed, active, weight);
        direction = 2;
        simpleAttackRanges = new ArrayList<>();
        simpleAttackRanges.add(new Rectangle(x, y - range, width, range));
        simpleAttackRanges.add(new Rectangle(x + width, y, range, height));
        simpleAttackRanges.add(new Rectangle(x, y + height, width, range));
        simpleAttackRanges.add(new Rectangle(x - range, y, range, height));
        name = "Player";
    }
    
    public void simpleAttack(){
        for(Creature c : Game.level.creatures){
            if(c == Game.level.player){
                continue;
            }
            if(simpleAttackRanges.get(direction).intersects(c) || simpleAttackRanges.get(direction).contains(c)){
                System.out.println("Gotcha!");
                c.gotHit(10);
            }
        }
    }
    
    @Override
    public void reloc(int x, int y) {
        this.x = x;
        sencorT.x = x;
        sencorB.x = x;
        sencorR.x = x + width - width/4;
        sencorL.x = x;
        
        simpleAttackRanges.get(0).x = x;
        simpleAttackRanges.get(1).x = x + width;
        simpleAttackRanges.get(2).x = x;
        simpleAttackRanges.get(3).x = x - range;
        
        this.y = y;
        sencorT.y = y;
        sencorB.y = y + height - height/4;
        sencorR.y = y;
        sencorL.y = y;
        
        simpleAttackRanges.get(0).y = y - range;
        simpleAttackRanges.get(1).y = y;
        simpleAttackRanges.get(2).y = y + height;
        simpleAttackRanges.get(3).y = y;
    }
    
}
