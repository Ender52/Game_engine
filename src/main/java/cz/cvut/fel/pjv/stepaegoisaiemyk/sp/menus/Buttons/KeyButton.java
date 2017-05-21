package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;

import java.awt.*;

public class KeyButton extends ItemButton {

    public KeyButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    @Override
    public void selectAction() {
        Game.level.player.inventory.get(positionInList).equiped = true;
        System.out.println("Key equiped");
    }

}
