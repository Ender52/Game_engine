package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.ExitButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.LevelOneStartButton;

/**
 * <p>Main menu class that represents individual buttons and the background</p>
 */
public class MainMenu extends IngameMenu {
    /**
     * <p>The construction of the main menu</p>
     *
     * @param x      The X coordinate of the menu
     * @param y      The Y coordinate of the menu
     * @param width  The width of the menu
     * @param height The height of the menu
     */
    public MainMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        buttons.add(new LevelOneStartButton("New game", x + 100, y + 100, 0));
        buttons.add(new ExitButton("Exit", x + 100, Game.HEIGHT - 100, 1));
        size = buttons.size();
    }
}
