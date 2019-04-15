package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels.MainMenuLevel;

public class MainMenuButton extends IngameButton {

    /**
     * <p>The construction of the button for opening main menu</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public MainMenuButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    /**
     * <p>The action that this button will do</p>
     * <p>This will open the main menu/p>
     */
    @Override
    public void selectAction() {
        Game.level = new MainMenuLevel();
    }
}
