package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.ExitButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.InfoButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.LevelOneStartButton;

public class PauseMenu extends IngameMenu {
    /**
     * <p>The construction of the pause menu</p>
     *
     * @param x      The X coordinate of the menu
     * @param y      The Y coordinate of the menu
     * @param width  The width of the menu
     * @param height The height of the menu
     */
    public PauseMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        buttons.add(new LevelOneStartButton("Restart", x + 15, y + 15, 0));
        buttons.add(new ExitButton("Exit", x + 15, Game.HEIGHT - 2 * y + 30, 1));
        size = buttons.size();
    }
}
