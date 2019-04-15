package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.IngameButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.MainMenuButton;

public class InfoMenu extends IngameMenu {

    /**
     * <p>The construction of the info menu</p>
     *
     * @param x      The X coordinate of the menu
     * @param y      The Y coordinate of the menu
     * @param width  The width of the menu
     * @param height The height of the menu
     */
    public InfoMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        buttons.add(new IngameButton("Use \"WASD\" to move", x + 100, y + 100, 0));
        buttons.add(new IngameButton("Press \"esc\" to pause the game", x + 100, y + 150, 1));
        buttons.add(new IngameButton("Press \"I\" to open inventory", x + 100, y + 200, 2));
        buttons.add(new IngameButton("Press \"R\" to drop equiped item from inventory", x + 100, y + 250, 3));
        buttons.add(new IngameButton("Press \"Space\" to attack, hold \"Space\" to perform stronger attack", x + 100, y + 300, 4));
        buttons.add(new IngameButton("Press \"F\" to open the door with the equiped key", x + 100, y + 350, 5));
        buttons.add(new MainMenuButton("Main Menu", x + 100, Game.HEIGHT - 100, 6));
        size = buttons.size();
    }
}
