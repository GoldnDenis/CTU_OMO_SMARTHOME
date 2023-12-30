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
        ConfigReader config = new ConfigReader();

        config.readJson("config1.json");
        List<CreatureAPI> creatures = config.setUpCreatures();
        SmartHome home = config.setUpHome();

        for (int day = 1; day <= config.getDuration(); ++day) {
            for (int hour = 0; hour < 24; ++hour) {
                System.out.println("Day " + day + ": " + hour + ":00");
                creatures.stream()
//                        .filter(creatureAPI -> !creatureAPI.isBusy())
                        .forEach(creatureAPI -> {
                            creatureAPI.move(home.getRooms());
                            creatureAPI.interact(home.getRooms());
                        });
            }
        }
    }
}
