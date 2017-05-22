package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels.*;

public class LevelOneStartButton extends IngameButton {

    /**
     * <p>The construction of the button for starting level one</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public LevelOneStartButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    /**
     * <p>The action that this button will do</p>
     * <p>This will play the level one</p>
     */
    @Override
    public void selectAction() {
        Game.level = new LevelOne();
        Game.new_log.writeToLog("Level One started", "INFO");
    }
}
