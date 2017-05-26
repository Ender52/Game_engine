package cz.cvut.fel.pjv.stepaegoisaiemyk.sp.utils;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static Logger logger = null;
    private static Log object = null;
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

    /**
     * <p>Providing the one and only log object</p>
     * <p>Creating log object, if none exists</p>
     *
     * @return log object
     */
    public static Log getObject() {
        if (object == null) {
            object = new Log();
        }
        return object;
    }

    /**
     * <p>Writing to the log</p>
     * <p>There are three different modes to write the log
     * "INFO" provides info messages
     * "WARNING" provides warning messages
     * "SEVERE" provides error messages</p>
     */
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
}
