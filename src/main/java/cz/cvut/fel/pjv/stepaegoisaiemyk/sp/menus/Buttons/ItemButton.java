package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

public class ItemButton extends IngameButton {

    /**
     * <p>The construction of the button for picking the item</p>
     *
     * @param s   The name of the button
     * @param x   The X coordinate of the button
     * @param y   The Y coordinate of the button
     * @param pos The position of the button in the menu
     */
    public ItemButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
    }

    /**
     * <p>The action that this button will do</p>
     * <p>TBD</p>
     */
    @Override
    public void selectAction() {
        System.out.println("none");
    }
}
