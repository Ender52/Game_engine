package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;


import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class IngameButton extends Rectangle {
    public Color color = Color.DARK_GRAY.darker(), activeColor = Color.DARK_GRAY, fontColor = Color.getHSBColor(0.5f, 0.6f, 0.7f), fontColorActive = Color.getHSBColor(0.5f, 0.6f, 0.7f);
    public Font font = new Font("Arial", 1, 35);
    public String name;
    public int fontX, fontY, positionInList;

    /**
     * <p>The construction of the ingame button</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public IngameButton(String s, int x, int y, int pos) {
        super(x, y, Game.WIDTH - x * 2, 50);
        fontX = x + 35;
        fontY = y + 35;
        name = s;
        positionInList = pos;
    }

    /**
     * <p>The action that this button will do</p>
     */
    public void selectAction() {
        System.out.println("None");
    }
}