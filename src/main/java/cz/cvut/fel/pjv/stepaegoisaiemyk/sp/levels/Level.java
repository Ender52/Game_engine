package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Item;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.Key;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Creature;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Door;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Obstacle;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.solids.Player;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.physics.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.*;

import java.awt.Color;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game.new_log;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.DamageBuff;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.ingameObjects.items.SpeedBuff;

/**
 * <p>One of the most important classes in the program, it keeps track of current logical state</p>
 */
public class Level {
    final int HEIGHT = Game.HEIGHT, WIDTH = Game.WIDTH;  //variables changing size of the frame; used everywhere
    public Color color;
    public Player player;
    Physics physics;
    public ArrayList<Obstacle> obstacles;
    public ArrayList<Creature> creatures;
    public ArrayList<IngameMenu> menus;
    public ArrayList<Item> items;
    public int time = 0;
    private long gameOverTime = -1;
    public boolean pause = true;
    private boolean EOF = false;
    String[] numbers = new String[6];
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
        if (player != null) {
            pause = !pause;
            pause();
        }
    }

    /**
     * <p>The key "I" was pressed</p>
     */
    public void iPressed() {
        if (player != null) {
            pause = !pause;
            openInventory();
        }
    }

    /**
     * <p>The key "R" was pressed</p>
     */
    public void rPressed() {
        if (player != null && !pause) {
            dropItem();
        }
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
        if (player != null) {
            player.openDoor();
        }
    }

    /**
     * <p>The key "E" was pressed</p>
     */
    public void ePressed() {
        if (player != null) {
            player.grapplingHookShoot();
        }
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
            if (player.charge > 3 && player.speedX == 0 && player.speedY == 0) {
                player.heavyAttack(player.damage);
            } else {
                player.simpleAttack(player.damage);
            }
            player.charge = 0;
        }
    }

    /**
     * <p>The key "E" was released</p>
     */
    public void eReleased() {
        if (player != null) {
            player.grapplingHookTerm();
        }
    }

    /**
     * <p>Removing dead objects</p>
     * <p>Removing taken keys, dead creatures, opened doors and dropped items from inventory</p>
     */
    public void removeDead() {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).taken) {
                items.remove(items.get(i));
            }
        }
        for (int i = 0; i < creatures.size(); i++) {
            if (!creatures.get(i).alive) {
                creatures.remove(creatures.get(i));
            }
        }
        for (int i = 0; i < obstacles.size(); i++) {
            if (!obstacles.get(i).active) {
                obstacles.remove(obstacles.get(i));
            }
        }
        if (Game.level.player != null) {
            for (int i = 0; i < player.inventory.size(); i++) {
                if (!player.inventory.get(i).taken) {
                    player.inventory.remove(player.inventory.get(i));
                }
            }
        }
    }

    public void levelLogic() {
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

    private void dropItem() {
        for (Item i : player.inventory) {
            if (i.equiped) {
                if (i instanceof SpeedBuff) {
                    player.speed -= 1;
                }
                if (i instanceof DamageBuff) {
                    player.damage -= 5;
                }
                i.taken = false;
                i.equiped = false;
                int d = player.direction;                   //0 - top, 1 - right, 2 - bottom, 3 - left
                int c = 50;
                if (d == 0) {
                    i.x = player.simpleAttackRanges.get(d).x + player.simpleAttackRanges.get(d).width / 2 - i.width / 2;
                    i.y = player.simpleAttackRanges.get(d).y - c - i.height / 2;
                } else if (d == 1) {
                    i.x = player.simpleAttackRanges.get(d).x + player.simpleAttackRanges.get(d).width + c - i.width / 2;
                    i.y = player.simpleAttackRanges.get(d).y + player.simpleAttackRanges.get(d).height / 2 - i.height / 2;
                } else if (d == 2) {
                    i.x = player.simpleAttackRanges.get(d).x + player.simpleAttackRanges.get(d).width / 2 - i.width / 2;
                    i.y = player.simpleAttackRanges.get(d).y + player.simpleAttackRanges.get(d).height + c - i.height / 2;
                } else if (d == 3) {
                    i.x = player.simpleAttackRanges.get(d).x - c - i.width / 2;
                    i.y = player.simpleAttackRanges.get(d).y + player.simpleAttackRanges.get(d).height / 2 - i.height / 2;
                }
                items.add(i);
                Game.new_log.writeToLog("Item " + i.name + " is dropped", "INFO");
            }
        }
    }

    /**
     * <p>Checks if item is picked</p>
     * <p>This function is called every "tick" and it changes taken property of the item, if it's picked</p>
     */
    public void ItemPicked() {
        for (Item i : items) {
            if (i.intersects(player) && !i.taken && player.inventory.size() < 5) {
                if (i instanceof SpeedBuff) {
                    player.speed += 1;
                }
                if (i instanceof DamageBuff) {
                    player.damage += 5;
                }
                i.taken = true;
                player.inventory.add(i);
                Game.new_log.writeToLog("Item " + i.name + " is picked", "INFO");
            }
        }
    }

    /**
     * <p>Pausing the game</p>
     * <p>Opens pause menu</p>
     */
    public void pause() {
        if (pause) {
            menu = new PauseMenu(300, 100, WIDTH - 600, HEIGHT - 200);
            menus.add(menu);
        } else {
            menus.remove(menu);
            menu = null;
        }
    }

    /**
     * <p>Loading inventory from the provided path</p>
     *
     * @param s The path to the .txt file that contains description of the inventory
     */
    public void loadInventory(String s) {
        String str = "";
        try {
            Scanner sc = new Scanner(new FileInputStream(s), "UTF-8");
            str = sc.nextLine();
        } catch (IOException e) {
            Game.new_log.writeToLog("Couldn't load inventory", "SEVERE");
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                player.inventory.add(new Key(0, 0, 15, 15, true, false));
            }
            if (str.charAt(i) == '2') {
                player.inventory.add(new DamageBuff(0, 0, 15, 15, true, false));
                player.damage += 5;
            }
            if (str.charAt(i) == '3') {
                player.inventory.add(new SpeedBuff(0, 0, 15, 15, true, false));
                player.speed += 1;
            }
        }
        Game.new_log.writeToLog("Inventory successfully loaded", "INFO");
    }

    /**
     * <p>Saving inventory to the provided path</p>
     *
     * @param s The path to the .txt file that will be overwritten every time this function is called
     */
    public void saveInventory(String s) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(s), "utf-8"))) {
            for (Item i : player.inventory) {
                if (i instanceof Key) {
                    writer.write("1");
                }
                if (i instanceof DamageBuff) {
                    writer.write("2");
                }
                if (i instanceof SpeedBuff) {
                    writer.write("3");
                }
            }
        } catch (IOException e) {
            Game.new_log.writeToLog("Couldn't save inventory", "SEVERE");
        }
        Game.new_log.writeToLog("Inventory successfully saved", "INFO");
    }

    /**
     * <p>Checks if the game is over</p>
     * <p>This function is called every "tick" and it changes the current level to the main menu level, if the game is over</p>
     */
    public void GameOver() {
        if (player != null && (creatures.size() == 1 || !player.alive)) {
            if (gameOverTime == -1) {
                gameOverTime = System.nanoTime();
            } else if ((System.nanoTime() - gameOverTime) / 1000000000 > 3) {               //waits 3 seconds before changing the current level
                if (creatures.get(0) instanceof Player) {
                    Game.new_log.writeToLog("Player won", "INFO");
                } else {
                    Game.new_log.writeToLog("Player lost", "INFO");
                }
                saveInventory("./src/main/resources/SAVEDinventory.txt");
                Game.new_log.writeToLog("Game is over", "INFO");
                Game.level = new MainMenuLevel();
            }
        }
    }


    /**
     * <p>Loading level from the provided path</p>
     *
     * @param s The path to the .txt file that contains description of the inventory
     */
    public void loadLevel(String s) {
        String str = "";
        try {
            Scanner sc = new Scanner(new FileInputStream(s), "UTF-8");
            while (!EOF) {
                if (!sc.hasNextLine()) {
                    break;
                }
                str = sc.nextLine();
                numbers = str.split(":");
                if (numbers[0].equals("1")) {         //creatures
                    creatures.add(new Creature(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]), Integer.parseInt(numbers[4]), 1, true, 3, 80, "/sprites/player"));
                    if (numbers[5].equals("9")) {
                        EOF = true;
                    }
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = "";
                    }
                    str = "";
                }
                if (numbers[0].equals("2")) {         //walls
                    obstacles.add(new Obstacle(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]), Integer.parseInt(numbers[4])));
                    if (numbers[5].equals("9")) {
                        EOF = true;
                    }
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = "";
                    }
                    str = "";
                }
                if (numbers[0].equals("3")) {         //doors
                    obstacles.add(new Door(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]), Integer.parseInt(numbers[4])));
                    if (numbers[5].equals("9")) {
                        EOF = true;
                    }
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = "";
                    }
                    str = "";
                }
                if (numbers[0].equals("4")) {         //keys
                    items.add(new Key(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]), Integer.parseInt(numbers[4]), false, false));
                    if (numbers[5].equals("9")) {
                        EOF = true;
                    }
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = "";
                    }
                    str = "";
                }
                if (numbers[0].equals("5")) {         //damagebuffs
                    items.add(new DamageBuff(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]), Integer.parseInt(numbers[4]), false, false));
                    if (numbers[5].equals("9")) {
                        EOF = true;
                    }
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = "";
                    }
                    str = "";
                }
                if (numbers[0].equals("6")) {         //speedbuffs
                    items.add(new SpeedBuff(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]), Integer.parseInt(numbers[4]), false, false));
                    if (numbers[5].equals("9")) {
                        EOF = true;
                    }
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = "";
                    }
                    str = "";
                }
            }
        } catch (IOException e) {
            Game.new_log.writeToLog("Couldn't load level", "SEVERE");
        }
        Game.new_log.writeToLog("Level successfully loaded", "INFO");
    }
}
