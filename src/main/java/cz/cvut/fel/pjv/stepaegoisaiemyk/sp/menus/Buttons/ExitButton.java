package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.Buttons;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.menus.IngameButton;
import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.utils.Log;

public class ExitButton extends IngameButton {

    private static Log new_log;

    public ExitButton(String s, int x, int y, int pos) {
        super(s, x, y, pos);
        //new_log = Log.getObject();
    }

    @Override
    public void selectAction() {
        Log.writeToLog("Game closed", "INFO");
        System.exit(0);
    }


}
