package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.IngameButton;

public class ExitButton extends IngameButton {

    public ExitButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    @Override
    public void selectAction() {
        System.exit(0);
    }
    
    
}
