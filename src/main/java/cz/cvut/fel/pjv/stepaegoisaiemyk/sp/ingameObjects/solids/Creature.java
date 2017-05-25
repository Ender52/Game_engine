package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.graphics.objectRenderers.CreatureRenderer;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Creature extends Solid {
    public ArrayList<Rectangle> simpleAttackRanges;
    public int speed, speedX, speedY, health, damage, range = 10, direction, animation, frame;
    public Rectangle sencorT, sencorB, sencorR, sencorL;
    public Color color = Color.white;
    public String name = "Creature", path = "/sprites/player";
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
     * @param path
     */
    public Creature(int x, int y, int width, int height, int speed, boolean active, int weight, int health, String path) {
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

        direction = 0;                      //0 - top, 1 - right, 2 - bottom, 3 - left
        simpleAttackRanges = new ArrayList<>();
        simpleAttackRanges.add(new Rectangle(x, y - range, width, range));
        simpleAttackRanges.add(new Rectangle(x + width, y, range, height));
        simpleAttackRanges.add(new Rectangle(x, y + height, width, range));
        simpleAttackRanges.add(new Rectangle(x - range, y, range, height));
        try {
            or = new CreatureRenderer(path);
        } catch (IOException ex) {
            Logger.getLogger(Creature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Creature.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        simpleAttackRanges.get(0).x = x;
        simpleAttackRanges.get(1).x = x + width;
        simpleAttackRanges.get(2).x = x;
        simpleAttackRanges.get(3).x = x - range;

        this.y = y;

        sencorT.y = y;
        sencorB.y = y + height - height / 4;
        sencorR.y = y;
        sencorL.y = y;

        simpleAttackRanges.get(0).y = y - range;
        simpleAttackRanges.get(1).y = y;
        simpleAttackRanges.get(2).y = y + height;
        simpleAttackRanges.get(3).y = y;
        
        checkDirection();
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

    /**
     * <p>Getter for creature's health variable</p>
     *
     * @return The health of the creature
     */
    public int getHealth() {
        return this.health;
    }


    private void die() {
        System.out.println("The creature " + name + " is dead now.");
        alive = false;
        Game.new_log.writeToLog("Creature " + name + " died", "INFO");
    }

    /**
     * <p>Simple attack</p>
     * <p>This type of attack will deal damage defined by:</p>
     * @param dmg amount of damage
     */
    public void simpleAttack(int dmg) {
        System.out.println("Simple attack!");
        for (Creature c : Game.level.creatures) {
            if (c == Game.level.player) {
                continue;
            }
            if (c.alive && simpleAttackRanges.get(direction).intersects(c)) {
                System.out.println("Gotcha!");
                c.gotHit(dmg);
            }
        }
    }
    

    private void checkDirection() {
        animation = 0;
        frame = Game.level.time % 50;
        if (speedX < 0) {
            direction = 3;
            animation = 1;
        }
        if (speedX > 0) {
            direction = 1;
            animation = 1;
        }
        if (speedY < 0) {
            direction = 0;
            animation = 1;
        }
        if (speedY > 0) {
            direction = 2;
            animation = 1;
        }
    }

}
