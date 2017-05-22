package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Key;

public class Player extends Creature {
    public ArrayList<Rectangle> simpleAttackRanges;
    public ArrayList<Item> inventory;
    public int range = 20;
    public int charge = 0;
    public int direction;
    public Rectangle grapplingHook = null;

    public Player(int x, int y, int width, int height, int speed, boolean active, int weight, int health) {
        super(x, y, width, height, speed, active, weight, health);
        direction = 0;                      //0 - top, 1 - right, 2 - bottom, 3 - left
        simpleAttackRanges = new ArrayList<>();
        simpleAttackRanges.add(new Rectangle(x, y - range, width, range));
        simpleAttackRanges.add(new Rectangle(x + width, y, range, height));
        simpleAttackRanges.add(new Rectangle(x, y + height, width, range));
        simpleAttackRanges.add(new Rectangle(x - range, y, range, height));

        inventory = new ArrayList<>(); //inventory
        name = "Player";
    }

    public void simpleAttack() {
        System.out.println("Simple attack!");
        for (Creature c : Game.level.creatures) {
            if (c == Game.level.player) {
                continue;
            }
            if (c.alive && simpleAttackRanges.get(direction).intersects(c)) {
                System.out.println("Gotcha!");
                c.gotHit(10);
            }
        }
    }

    public void charging() {
        charge++;
    }

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

    public void grapplingHookShoot() {
        if (grapplingHook == null) {
            grapplingHookInit();
        }
        System.out.println("Shooting the hook...");
    }

    public void grapplingHookPull() {
        System.out.println("Pulling the hook...");
    }

    public void grapplingHookTerm() {
        grapplingHook = null;
        System.out.println("The hook's been stopped!");
    }

    public void openDoor() {
        for (Obstacle o : Game.level.obstacles) {
            for (Item i : Game.level.player.inventory)
                if (o instanceof Door && i instanceof Key) {
                    if (i.equiped == true) {
                        ((Door) o).active = false;
                        System.out.println("Door opened");
                    }
                }
        }
        Game.new_log.writeToLog("Door is opened", "INFO");
    }

    @Override
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
    }

}
