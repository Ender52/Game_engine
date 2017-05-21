package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.utils;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    public static Logger logger = null;
    public static Log object = null;
    FileHandler fh;

    private Log() {
        String file_name = "log.txt";
        try {
            File f = new File(file_name);
            if (!f.exists()) {
                f.createNewFile();
            }
            fh = new FileHandler(file_name, true);
            logger = Logger.getLogger("Logger");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Log getObject() {
        if (object == null) {
            object = new Log();
        }
        return object;
    }

    public static void writeToLog(String msg, String lvl) {
        object.logger.setLevel(Level.ALL);
        if (lvl == "INFO") {
            object.logger.info(msg);
        } else if (lvl == "WARNING") {
            object.logger.warning(msg);
        } else if (lvl == "SEVERE") {
            object.logger.severe(msg);
        }

    }

    //this.getclass().getname()
}
