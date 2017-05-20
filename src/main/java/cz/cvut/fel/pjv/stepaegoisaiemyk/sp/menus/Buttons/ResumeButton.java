package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.IngameButton;

public class ResumeButton extends IngameButton{

    public ResumeButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    @Override
    public void selectAction() {
        Game.level.pause = !Game.level.pause;
        Game.level.pause();
    }
}
