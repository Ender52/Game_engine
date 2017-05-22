package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.physics;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Item;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Obstacle;

import java.awt.Rectangle;
/**
 * <p>The main logic class</p>
 * <p>Checks if the current logical situation of the game fits the laws of the world and fixes it if it doesn't</p>
 * 
 */
public class Physics {

    /**
     * <p>Initializing the physics</p>
     * <p>TBD</p>
     */
    public void run() {
        if (Game.level.pause) {
            return;
        }
        Game.level.levelLogic();
        for (Creature c : Game.level.creatures) {
            int x = 0, y = 0;
            if (c.active && c.alive && collision(c)) {
                if (collision(c.sencorT) || collisionCreature(c)) {
                    y += 1;
                }
                if (collision(c.sencorB) || collisionCreature(c)) {
                    y += -1;
                }
                if (collision(c.sencorR) || collisionCreature(c)) {
                    x += -1;
                }
                if (collision(c.sencorL) || collisionCreature(c)) {
                    x += 1;
                }
            }
            move(c, c.speedX, c.speedY, c.speed);
            react(c, x, y);
        }
        ItemPicked();
        Game.level.checkDirection();
    }


    private boolean collision(Rectangle r) {
        for (Obstacle o : Game.level.obstacles) {
            if (r.intersects(o)) {
                return true;
            }
        }
        return false;
    }

    private boolean collisionCreature(Rectangle r) {
        for (Creature c : Game.level.creatures) {
            if (c.alive && r != c && r.intersects(c)) {
                return true;
            }
        }
        return false;
    }

    private void move(Creature r, int x, int y, int speed) {  //changes the position of the player
        if ((x == 0 && y == 0) || !r.active) {
            return;
        }
        int i = 0;
        r.x += x;
        r.y += y;
        while ((collision(r) || collisionCreature(r)) && i != speed) {
            r.x -= x / speed;
            r.y -= y / speed;
            i++;
        }
        r.reloc(r.x, r.y);
    }

    private void react(Creature r, int x, int y) {
        if ((x == 0 && y == 0) || !r.active) {
            return;
        }
        while (collision(r) || collisionCreature(r)) {
            r.x += x;
            r.y += y;
        }
        r.reloc(r.x, r.y);
    }

    private void ItemPicked() {
        for (Item i : Game.level.items) {
            if (i.intersects(Game.level.player) && !i.taken && Game.level.player.inventory.size() < 5) {
                i.taken = true;
                Game.level.player.inventory.add(i);
                Game.new_log.writeToLog("Item "+ i.name +" is picked", "INFO");
            }
        }

    }


}
