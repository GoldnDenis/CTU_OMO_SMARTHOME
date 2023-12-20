package cvut.fel.omo.system;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {

    private static final Logger logger = Logger.getLogger("Logger");

    //todo: 3. parameter source location
    public static void log(Level level, String message) {
        logger.log(level, message);
    }

}
