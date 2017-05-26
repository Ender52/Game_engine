package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.utils.Log;

public class ExitButton extends IngameButton {

    /**
     * <p>The construction of the button for quiting the game</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public ExitButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    /**
     * <p>The action that this button will do</p>
     * <p>This will close the game</p>
     */
    @Override
    public void selectAction() {
        Log.writeToLog("Game closed", "INFO");
        System.exit(0);
    }
}
