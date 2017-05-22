package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;

import java.awt.Color;
import java.awt.Rectangle;

public class Creature extends Solid {
    public int speed, speedX, speedY, health;
    public Rectangle sencorT, sencorB, sencorR, sencorL;
    public Color color = Color.white;
    public String name = "Creature";
    public boolean alive;

    /**
     * <p>The construction of the creature</p>
     *
     * @param x      The X coordinate of the creature
     * @param y      The Y coordinate of the creature
     * @param width  The width of the creature
     * @param height The height of the creature
     * @param speed  The speed of the creature
     * @param active Tells if the creature will prevent another creature to go through it
     * @param weight The weight of the creature
     * @param health The health of the creature
     */
    public Creature(int x, int y, int width, int height, int speed, boolean active, int weight, int health) {
        alive = true;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.active = active;
        this.weight = weight;
        this.health = health;
        sencorT = new Rectangle(this.x, this.y, this.width, this.height / 4);
        sencorB = new Rectangle(this.x, y + this.height - this.height / 4, this.width, this.height / 4);
        sencorR = new Rectangle(this.x + this.width - this.width / 4, y, this.width / 4, this.height);
        sencorL = new Rectangle(this.x, this.y, this.width / 4, this.height);
    }

    /**
     * <p>Relocate the creature</p>
     *
     * @param x The X coordinate, which tells for how much the creature will be relocated
     * @param y The Y coordinate, which tells for how much the creature will be relocated
     */

    public void reloc(int x, int y) {
        this.x = x;
        sencorT.x = x;
        sencorB.x = x;
        sencorR.x = x + width - width / 4;
        sencorL.x = x;
        this.y = y;
        sencorT.y = y;
        sencorB.y = y + height - height / 4;
        sencorR.y = y;
        sencorL.y = y;
    }

    /**
     * <p>Damage the creature</p>
     *
     * @param dmg The amount of damage the creature will get
     */

    public void gotHit(int dmg) {
        if (health > 1) {
            System.out.println(name + ": Ouch! -" + dmg);
            health -= dmg;
            if (health < 1) {
                die();
            }
        }
    }

    public int getHealth(){
       return this.health;
    }



    private void die() {
        System.out.println("The creature " + name + " is dead now.");
        alive = false;
        Game.new_log.writeToLog("Creature " + name + " died", "INFO");
    }

}
