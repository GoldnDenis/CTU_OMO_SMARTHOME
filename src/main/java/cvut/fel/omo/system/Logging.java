package cvut.fel.omo.system;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {

    private static final Logger logger = Logger.getLogger(Logging.class.getName());

    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    public static void log(Level level, String message, String source) {
        String logText = '"' + message + '"' + " from " + source;
        logger.log(level, logText);
    }

    public static void log(Level level, String appliance, String creature, String message) {
        String logText = '"' + creature + " is using " + appliance + " and " + message + '"';
        logger.log(level, logText);
    }
}
