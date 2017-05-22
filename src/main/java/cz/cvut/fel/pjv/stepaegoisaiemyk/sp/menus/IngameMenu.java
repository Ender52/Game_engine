package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.*;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class IngameMenu extends Rectangle {
    public Color color = Color.DARK_GRAY.darker();
    public ArrayList<IngameButton> buttons;
    public int position = 0;
    public int size = 0;

    public IngameMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        buttons = new ArrayList<>();
    }

    public void wPressed() {
        position--;
        if (position < 0) {
            position = size - 1;
        }
    }

    public void sPressed() {
        position++;
        if (position > size - 1) {
            position = 0;
        }
    }

    public void select() {
        IngameButton b = buttons.get(position);
        b.selectAction();
    }
}

