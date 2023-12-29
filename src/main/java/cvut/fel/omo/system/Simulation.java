package cvut.fel.omo.system;

import cvut.fel.omo.appliance.state.Active;
import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.Room;
import cvut.fel.omo.home.SmartHome;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Simulation {

    public void run() {
//        ConfigGenerator.createJSON(14, List.of("Musta", "Denis", "Jiri Sebek"), List.of("Kitchen", "Living Room"));

        ConfigReader config = new ConfigReader();
//
        config.readJson("config1.json");
        SmartHome home = config.setUpHome();

        // todo::creatures walk

        int simDuration = config.getDuration();

        System.out.println(simDuration);

        for (int day = 1; day <= simDuration; ++day) {
            for (int hour = 0; hour < 24; ++hour) {
                home.getRooms().stream()
                        .flatMap(room -> room.getCreatures().stream())
                        .filter(CreatureAPI::isBusy)
                        .forEach(CreatureAPI::interact);
            }
        }
    }
}
