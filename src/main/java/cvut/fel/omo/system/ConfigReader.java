package cvut.fel.omo.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.creature.factory.CreatureFactory;
import cvut.fel.omo.home.SmartHome;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ConfigReader {
    private ImmutableConfig config;

    public void readJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            config = objectMapper.readValue(new File(filePath), ImmutableConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SmartHome setUpHome() {
        SmartHome home = new SmartHome();

        for (String room: config.roomList()) {
            home.addNewRoom(room);
        }

        return home;
    }

    public List<CreatureAPI> setUpCreatures() {
        List<CreatureAPI> creatures = new ArrayList<>();

        CreatureFactory factory = new CreatureFactory();
        for (String creatureElement: config.creatureList()) {
            String[] components = creatureElement.split(" ");
            Optional<CreatureAPI> createdCreature = factory.createCreature(components[1], components[0]);
            createdCreature.ifPresent(creatures::add);
        }

        return creatures;
    }

    public int getDuration() {
        return config.simDuration();
    }
}
