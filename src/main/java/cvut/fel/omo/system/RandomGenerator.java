package cvut.fel.omo.system;

import java.util.Random;

public class RandomGenerator {

    public static int generateNumber(int bound) {
        return new Random().nextInt(bound);
    }

    public static boolean hasHappened(double percent) {
        if ( percent <= 0 ) return false;
        if ( percent >= 100 ) return true;

        return generateNumber(100) >= percent;
    }
}
