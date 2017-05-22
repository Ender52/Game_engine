package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids;

import java.awt.Rectangle;
import java.util.ArrayList;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Item;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Key;

/**
 * The class responsible for logical and graphical representation of the player in the game </p>
 */
public class Player extends Creature {
    public ArrayList<Item> inventory;
    public int charge = 0;
    public Rectangle grapplingHook = null;

    /**
     * <p>The construction of the player</p>
     *
     * @param x      The X coordinate of the player
     * @param y      The Y coordinate of the player
     * @param width  The width of the player
     * @param height The height of the player
     * @param speed  The speed of the player
     * @param active Tells if the player will prevent another creature to go through it
     * @param weight The weight of the player
     * @param health The health of the player
     */

    public Player(int x, int y, int width, int height, int speed, boolean active, int weight, int health) {
        super(x, y, width, height, speed, active, weight, health);
        inventory = new ArrayList<>(); //inventory
        name = "Player";
        damage = 10;
    }

    /**
     * <p>Charging the weapon for the heavy attack</p>
     */
    public void charging() {
        charge++;
    }

    /**
     * <p>Heavy attack</p>
     * <p>This type of attack will deal 20 damage</p>
     */
    public void heavyAttack() {
        speedX = 0;
        speedY = 0;
        System.out.println("Heavy attack!");
        for (Creature c : Game.level.creatures) {
            if (c == Game.level.player || !c.alive) {
                continue;
            }
            if (simpleAttackRanges.get(direction).intersects(c)) {
                System.out.println("Gotcha!");
                c.gotHit(20);
            }
        }
    }


    private void grapplingHookInit() {
        grapplingHook = new Rectangle(0, 0, 0, 0);
        System.out.println("The hook's been initialized!");
    }

    /**
     * <p>Shooting the grappling hook</p>
     */
    public void grapplingHookShoot() {
        if (grapplingHook == null) {
            grapplingHookInit();
        }
        System.out.println("Shooting the hook...");
    }

    /**
     * <p>Pulling the grappling hook</p>
     * <p>TBD</p>
     */
    public void grapplingHookPull() {
        System.out.println("Pulling the hook...");
    }

    /**
     * <p>Grappling hook termination</p>
     */
    public void grapplingHookTerm() {
        grapplingHook = null;
        System.out.println("The hook's been stopped!");
    }

    /**
     * <p>Openning the door</p>
     * <p>The door will open only if the key is equiped and player stays right next to the door</p>
     */

    public void openDoor() {
        for (Obstacle o : Game.level.obstacles) {
            for (Item i : Game.level.player.inventory) {
                if (o instanceof Door && i instanceof Key) {
                    if (i.equiped == true && Game.level.pause == false) {
                        ((Door) o).active = false;
                        System.out.println("Door opened");
                        Game.new_log.writeToLog("Door is opened", "INFO");
                    }
                }
            }
        }
    }
}
