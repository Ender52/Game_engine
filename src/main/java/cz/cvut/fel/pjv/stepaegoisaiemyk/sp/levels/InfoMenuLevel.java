package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.InfoMenu;

/**
 * <p>The class that will be called if user wants to know game's hotkeys</p>
 * <p>It contains the information about hotkeys</p>
 */
public class InfoMenuLevel extends Level {
    /**
     * <p>Info menu constructor</p>
     * <p>Creates the menu and sets the player to null for other classes to ignore</p>
     */
    public InfoMenuLevel() {
        super();
        menu = new InfoMenu(0, 0, Game.WIDTH, Game.HEIGHT);
        menus.add(menu);
        pause = true;
        player = null;
    }
}
