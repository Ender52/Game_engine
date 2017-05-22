package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Item;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Obstacle;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Player;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.physics.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;

import java.awt.Color;
import java.util.ArrayList;


public class Level {
    final int HEIGHT = Game.HEIGHT, WIDTH = Game.WIDTH;  //variables changing size of the frame; used everywhere
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

    /**
     * <p>The construction of the level</p>
     */
    public Level() {  //constructor
        color = Color.DARK_GRAY;
        physics = new Physics();

        creatures = new ArrayList<>();  //the creatures in a list for comfortable usage

        obstacles = new ArrayList<>();  //the walls in a list for comfortable usage

        items = new ArrayList<>(); //items on the floor

        menus = new ArrayList<>();  //menus
    }

    /**
     * <p>The key "W" was pressed</p>
     */
    public void wPressed() {
        if (!pause) {
            player.speedY = -player.speed;
        } else {
            menu.wPressed();
        }
    }

    /**
     * <p>The key "S" was pressed</p>
     */
    public void sPressed() {
        if (!pause) {
            player.speedY = player.speed;
        } else {
            menu.sPressed();
        }
    }

    /**
     * <p>The key "A" was pressed</p>
     */
    public void aPressed() {
        if (!pause) {
            player.speedX = -player.speed;
        }
    }

    /**
     * <p>The key "D" was pressed</p>
     */
    public void dPressed() {
        if (!pause) {
            player.speedX = player.speed;
        }
    }

    /**
     * <p>The key "ESC" was pressed</p>
     */
    public void escPressed() {
        pause = !pause;
        pause();
    }

    /**
     * <p>The key "I" was pressed</p>
     */
    public void iPressed() {
        pause = !pause;
        openInventory();
    }

    /**
     * <p>The key "ENTER" was pressed</p>
     */
    public void enterPressed() {
        if (pause) {
            menu.select();
        }
    }

    /**
     * <p>The key "SPACE" was pressed</p>
     */
    public void spacePressed() {
        if (!pause) {
            player.charging();
        }
    }

    /**
     * <p>The key "F" was pressed</p>
     */
    public void fPressed() {
        player.openDoor();
    }

    /**
     * <p>The key "E" was pressed</p>
     */
    public void ePressed() {
        player.grapplingHookShoot();
    }

    /**
     * <p>The key "W" was released</p>
     */
    public void wReleased() {
        if (!pause)
            player.speedY = 0;
    }

    /**
     * <p>The key "S" was released</p>
     */
    public void sReleased() {
        if (!pause)
            player.speedY = 0;
    }

    /**
     * <p>The key "A" was released</p>
     */
    public void aReleased() {
        if (!pause)
            player.speedX = 0;
    }

    /**
     * <p>The key "D" was released</p>
     */
    public void dReleased() {
        if (!pause)
            player.speedX = 0;
    }

    /**
     * <p>The key "SPACE" was released</p>
     */
    public void spaceReleased() {
        if (!pause) {
            if (player.charge > 5 && player.speedX == 0 && player.speedY == 0) {
                player.heavyAttack();
            } else {
                player.simpleAttack();
            }
            player.charge = 0;
        }
    }

    /**
     * <p>The key "E" was released</p>
     */
    public void eReleased() {
        player.grapplingHookTerm();
    }

    /**
     * <p>Removing dead objects</p>
     * <p>Removing taken keys, dead creatures, opened doors</p>
     */
    public void removeDead() {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).taken == true) {
                items.remove(items.get(i));
            }
        }
        for (int i = 0; i < creatures.size(); i++) {
            if (creatures.get(i).alive == false) {
                creatures.remove(creatures.get(i));
            }
        }
        for (int i = 0; i < obstacles.size(); i++) {
            if (obstacles.get(i).active == false) {
                obstacles.remove(obstacles.get(i));
            }
        }
    }

    /**
     * <p>TBD</p>
     */
    public void levelLogic() {
        pause();
    }

    /**
     * <p>Openning inventory</p>
     */
    private void openInventory() {
        if (pause) {
            menu = new InventoryMenu(100, 100, WIDTH - 200, 330);
            menus.add(menu);
        } else {
            menus.remove(menu);
            menu = null;
        }
    }

    public void checkDirection() {
        if (player.speedX < 0) {
            player.direction = 3;
        }
        if (player.speedX > 0) {
            player.direction = 1;
        }
        if (player.speedY < 0) {
            player.direction = 0;
        }
        if (player.speedY > 0) {
            player.direction = 2;
        }
    }

    public void pause() {
        if (pause) {
            menu = new PauseMenu(300, 100, WIDTH - 600, HEIGHT - 200);
            menus.add(menu);
        } else {
            menus.remove(menu);
            menu = null;
        }
    }
}
