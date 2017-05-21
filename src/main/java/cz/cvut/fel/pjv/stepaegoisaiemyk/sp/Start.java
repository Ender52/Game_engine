package cz.cvut.fel.pjv.stepaegoisaiemyk.sp;


import cz.cvut.fel.pjv.stepaegoisaiemyk.sp.utils.Log;

import java.util.logging.Level;

public class Start{

    public static void main(String[] args) {
        Game game = new Game();
        try {
            Log my_log = new Log("log.txt");
            my_log.logger.setLevel(Level.ALL);
            my_log.logger.info("Info msg");
            my_log.logger.severe("Sever msg");
            //log.info("Game started");
        } catch (Exception e){}
    }
}