package cvut.fel.omo.system;

import java.util.Random;

public class RandomGenerator {
    public static boolean hasHappened(double percent) {
        if ( percent <= 0 ) return false;
        if ( percent >= 100 ) return true;

        Random random = new Random();

        return random.nextInt(100) >= percent;
    }
}
