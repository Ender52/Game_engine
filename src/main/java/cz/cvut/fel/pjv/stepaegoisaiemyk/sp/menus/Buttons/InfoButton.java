package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels.InfoMenuLevel;

public class InfoButton extends IngameButton {

    /**
     * <p>The construction of the button for opening info menu</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public InfoButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    /**
     * <p>The action that this button will do</p>
     * <p>This will open the info window about key bindings</p>
     */
    @Override
    public void selectAction() {
        Game.level = new InfoMenuLevel();
    }
}
