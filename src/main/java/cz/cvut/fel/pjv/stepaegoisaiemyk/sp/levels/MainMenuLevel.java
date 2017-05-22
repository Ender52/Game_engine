package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.levels;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.MainMenu;
/**
 * <p>The class that's supposed to be called at the beginning of the game </p>
 * <p>It contains the main menu from where the first level is launched </p>
 * 
 */
public class MainMenuLevel extends Level{
    /**
     * <p>Main menu constructor</p>
     * <p>Creates the menu and sets the player to null for other classes to ignore</p>
     */
    public MainMenuLevel(){
        super();
        menu = new MainMenu(0, 0, Game.WIDTH, Game.HEIGHT);
        menus.add(menu);
        pause = true;
        player = null;
    }
}
