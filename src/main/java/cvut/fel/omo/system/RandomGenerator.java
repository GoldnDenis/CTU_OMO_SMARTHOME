package cvut.fel.omo.system;

import java.util.List;
import java.util.Random;

public class RandomGenerator {

    public static int generateNumber(int bound) {
        if (bound <= 0) return 0;
        return new Random().nextInt(bound);
    }

    public static int generateNumberWithout(int bound, List<Integer> exclude) {
        if ( exclude.isEmpty() ) return generateNumber(bound);

        int ret = exclude.get(0);
        while ( exclude.contains(ret) ) {
            ret = generateNumber(bound);
        }

        return ret;
    }

    public static boolean hasHappened(double percent) {
        if ( percent <= 0 ) return false;
        if ( percent >= 100 ) return true;

        return generateNumber(100) >= percent;
    }
}
