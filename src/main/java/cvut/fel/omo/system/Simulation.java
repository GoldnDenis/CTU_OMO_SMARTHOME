package cvut.fel.omo.system;

import cvut.fel.omo.creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    public void run() {
        // read Config
        List<Creature> creatures = new ArrayList<>();
        // setup home
        // load creatures

        int reqDays = 24; // tmp - to-read from config
        for (int day = 1; day <= reqDays; ++day) {
            for (int hour = 0; hour < 24; ++hour) {
//                System.out.println("Day " + day + " - " + hour + ":00");
                creatures.stream()
                        .filter( Creature::getIsBusy )
                        .forEach( creature -> creature.doSomething() );
                }
            }
        }
    }
}
