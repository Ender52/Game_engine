package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.Game;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.BuffButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.ItemButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.KeyButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons.ResumeButton;

public class InventoryMenu extends IngameMenu {
    /**
     * <p>The construction of the inventory menu</p>
     *
     * @param x      The X coordinate of the menu
     * @param y      The Y coordinate of the menu
     * @param width  The width of the menu
     * @param height The height of the menu
     */
    public InventoryMenu(int x, int y, int width, int height) {
        super(x, y, width, height);
        listItems();
        buttons.add(new ResumeButton("Close", x + 15, y + height - 65, buttons.size()));
        size = buttons.size();
    }

    private void listItems() {
        for (int i = 0; i < Game.level.player.inventory.size(); i++) {
            if (Game.level.player.inventory.get(i).name == "Key") {
                buttons.add(new KeyButton(Game.level.player.inventory.get(i).name, x + 15, y + 15 + 50 * i, i));
            } else {
                buttons.add(new BuffButton(Game.level.player.inventory.get(i).name, x + 15, y + 15 + 50 * i, i));
            }
        }
    }
}
