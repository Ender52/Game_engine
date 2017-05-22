package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;

import java.awt.*;

public class KeyButton extends ItemButton {

    /**
     * <p>The construction of the button for picking the key</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public KeyButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    /**
     * <p>The action that this button will do</p>
     * <p>This will equip the key</p>
     */
    @Override
    public void selectAction() {
        Game.level.player.inventory.get(positionInList).equiped = true;
        System.out.println("Key equiped");
        Game.new_log.writeToLog("Key is equiped", "INFO");
    }

}
