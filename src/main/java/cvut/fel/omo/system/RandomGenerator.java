package cvut.fel.omo.system;

import java.util.Random;

public class RandomGenerator {

    public static int gemerateNumber(int boumd) {
        return new Random().nextInt(boumd);
    }

    public static boolean hasHappened(double percent) {
        if ( percent <= 0 ) return false;
        if ( percent >= 100 ) return true;

        return gemerateNumber(100) >= percent;
    }
}
