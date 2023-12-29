package cvut.fel.omo.system;

import cvut.fel.omo.appliance.state.Active;
import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.Room;
import cvut.fel.omo.home.SmartHome;

import java.util.stream.Stream;

public class Simulation {

    public void run() {
        Config config = new Config();
        SmartHome smartHome = config.setUpHome();
        int simulationPeriod = config.getPeriod();

        for (int day = 1; day <= simulationPeriod; ++day) {
            for (int hour = 0; hour < 24; ++hour) {
//                System.out.println("Day " + day + " - " + hour + ":00");
                Stream<Room> roomStream = smartHome.getFloors().stream()
                        .flatMap(floor -> floor.getRooms().stream());

                Stream<Creature> creatureStream = roomStream
                        .flatMap(room -> room.getCreatures().stream())
                        .filter(Creature::getIsBusy)
                        .forEach(creature -> creature.accept(
                                roomStream.flatMap(room -> room.getAppliances().stream())
                                        .
                        ));
                Stream<ApplianceAPI> applianceStream = roomStream
                        .flatMap(room -> room.getAppliances().stream())
                        .filter(appliance -> ! (appliance.getState() instanceof Active));

                }
            }
        }
    }
}
