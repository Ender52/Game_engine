package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.IngameButton;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class IngameMenu extends Rectangle {
    public Color color = Color.DARK_GRAY.darker();
    public ArrayList<IngameButton> buttons;
    public int position = 0;
    public int size = 0;

    /**
     * <p>The construction of the ingame menu</p>
     *
     * @param x      The X coordinate of the menu
     * @param y      The Y coordinate of the menu
     * @param width  The width of the menu
     * @param height The height of the menu
     */
    public IngameMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        buttons = new ArrayList<>();
    }

    /**
     * <p>The key "W" was pressed</p>
     */
    public void wPressed() {
        position--;
        if (position < 0) {
            position = size - 1;
        }
    }

    /**
     * <p>The key "S" was pressed</p>
     */
    public void sPressed() {
        position++;
        if (position > size - 1) {
            position = 0;
        }
    }

    /**
     * <p>Selecting the button</p>
     */
    public void select() {
        IngameButton b = buttons.get(position);
        b.selectAction();
    }
}

