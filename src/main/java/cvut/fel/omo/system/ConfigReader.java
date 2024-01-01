package cvut.fel.omo.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.factory.CreatureFactory;
import cvut.fel.omo.home.SmartHome;
import cvut.fel.omo.report.HouseConfigurationReport;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConfigReader {
    @Getter
    private ImmutableConfig config;

    public void readJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        String configFile;

        try {
            config = objectMapper.readValue(new File(filePath), ImmutableConfig.class);
            configFile = filePath;
        } catch (IOException e) {
            System.err.println("Something went wrong with the specified config file\nLoading a preset configurations");
            config = getStandardConfig();
            configFile = "preset";
        }

        HouseConfigurationReport.generateReport(configFile);
    }

    private ImmutableConfig getStandardConfig() {
        int simDuration = 7;
        List<String> creatures = List.of(
                "Musta Adult", "Denis Adult", "Jiri Adult", "Alex Adult",
                "Daniel Child", "Honda Child",
                "Bonnie Animal", "Bobik Animal", "Murky Animal"
        );
        List<String> rooms = List.of(
                "Living Room", "Kitchen",
                "Bedroom", "Bedroom", "Shower", "Office",
                "Shower", "Bedroom"
        );

        return new ImmutableConfig(simDuration, creatures, rooms);
    }

    public SmartHome setUpHome() {
        SmartHome home = new SmartHome();

        for (String room : config.roomList()) {
            home.addNewRoom(room);
        }

        return home;
    }

    public List<CreatureAPI> setUpCreatures() {
        List<CreatureAPI> creatures = new ArrayList<>();

        CreatureFactory factory = new CreatureFactory();
        for (String creatureElement : config.creatureList()) {
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
