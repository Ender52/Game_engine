package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels.*;

public class LevelOneStartButton extends IngameButton{

    public LevelOneStartButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }
    
    @Override
    public void selectAction() {
        Game.level = new LevelOne();
    }
}
