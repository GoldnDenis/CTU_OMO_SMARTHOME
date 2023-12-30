package cvut.fel.omo.system;

import cvut.fel.omo.appliance.LocalEventDetector;
import cvut.fel.omo.appliance.state.Active;
import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.creature.LocalEventListener;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.home.Room;
import cvut.fel.omo.home.SmartHome;
import cvut.fel.omo.sensor.GlobalEventDetector;
import cvut.fel.omo.sensor.GlobalEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Simulation {

    public void run() {
        ConfigReader config = new ConfigReader();

        config.readJson("config1.json");
        List<CreatureAPI> creatures = config.setUpCreatures();
        SmartHome home = config.setUpHome();

        GlobalEventDetector globalEventDetector = new GlobalEventDetector();
        home.getRooms()
                .stream()
                .flatMap(room -> room.getAppliances().stream())
                .forEach(applianceAPI ->
                        globalEventDetector.attach(new GlobalEventListener(applianceAPI))
                );

        LocalEventDetector localEventDetector = new LocalEventDetector();
        creatures.stream()
                .filter(creatureAPI -> creatureAPI instanceof Adult)
                .forEach(creatureAPI ->
                        localEventDetector.attach(new LocalEventListener(creatureAPI))
                );

        for (int day = 1; day <= config.getDuration(); ++day) {
            for (int hour = 0; hour < 24; ++hour) {
                System.out.println("Day " + day + ": " + hour + ":00");

                if (hour == 6) {
                    globalEventDetector.notifyAll(GLOBAL_EVENT.SUN_HAS_RISEN_UP);
                }

                if (hour == 19) {
                    globalEventDetector.notifyAll(GLOBAL_EVENT.NIGHT_FELL);
                }

                generateGlobalEvent().ifPresent(globalEventDetector::notifyAll);

                List<ApplianceAPI> brokenAppliances =
                        home.getRooms()
                                .stream()
                                .flatMap(room -> room.getAppliances().stream())
                                .filter(ApplianceAPI::isBroken)
                                .collect(Collectors.toList());

                brokenAppliances.forEach(localEventDetector::notifyFirstNotBusy);

                creatures.stream()
//                        .filter(creatureAPI -> !creatureAPI.isBusy())
                        .forEach(creatureAPI -> {
                            creatureAPI.move(home.getRooms());
                            creatureAPI.interact(home.getRooms());
                        });
            }
        }
    }

    private Optional<GLOBAL_EVENT> generateGlobalEvent() {
        if (RandomGenerator.hasHappened(0.1)) {
            return Optional.of(GLOBAL_EVENT.ELECTRICITY_SHUT_OFF);
        }
        if (RandomGenerator.hasHappened(0.1)) {
            return Optional.of(GLOBAL_EVENT.WATER_SHUT_OFF);
        }
        if (RandomGenerator.hasHappened(0.1)) {
            return Optional.of(GLOBAL_EVENT.NON_SATISFYING_TEMP);
        }
        return Optional.empty();
    }
}
