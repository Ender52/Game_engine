package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.IngameButton;

public class LevelOneStartButton extends IngameButton {

    public LevelOneStartButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    @Override
    public void selectAction() {
        Game.level = new LevelOne();
        Game.new_log.writeToLog("Level One started", "INFO");
    }
}
