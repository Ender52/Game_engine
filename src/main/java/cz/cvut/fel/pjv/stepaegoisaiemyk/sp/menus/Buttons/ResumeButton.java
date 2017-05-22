package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;

public class ResumeButton extends IngameButton {

    /**
     * <p>The construction of the button for resuming the game from pause</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public ResumeButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    /**
     * <p>The action that this button will do</p>
     * <p>This will unpause the game</p>
     */
    @Override
    public void selectAction() {
        Game.level.pause = !Game.level.pause;
        Game.level.pause();
    }
}
