package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects;


import java.awt.Color;
import java.awt.Rectangle;

public class Creature extends Solid{
    public int speed, speedX, speedY;
    public Rectangle sencorT, sencorB, sencorR, sencorL;
    public Color color = Color.white;
    public String name = "Creature";
    
    public Creature(int x, int y, int width, int height, int speed, boolean active, int weight) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.active = active;
        this.weight = weight;
        sencorT = new Rectangle(this.x, this.y, this.width, this.height / 4);
        sencorB = new Rectangle(this.x, y + this.height - this.height/4, this.width, this.height / 4);
        sencorR = new Rectangle(this.x + this.width - this.width / 4, y, this.width / 4, this.height);
        sencorL = new Rectangle(this.x, this.y, this.width / 4, this.height);
    }

    public void reloc(int x, int y) {
        this.x = x;
        sencorT.x = x;
        sencorB.x = x;
        sencorR.x = x + width - width/4;
        sencorL.x = x;
        this.y = y;
        sencorT.y = y;
        sencorB.y = y + height - height/4;
        sencorR.y = y;
        sencorL.y = y;
    }
    
    public void gotHit(int dmg){
        System.out.println(name + ": Ouch! -" + dmg);
    }

}
