package cz.cvut.fel.pjv.stepaegoisaiemyk.sp;

import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.utils.Log;

public class Start {

    private static Log new_log;

    public static void main(String[] args) {
        Game game = new Game();
        new_log = Log.getObject();
        Log.writeToLog("Game started", "INFO");
    }
}