package cvut.fel.omo.system.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import cvut.fel.omo.system.ImmutableConfig;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigGenerator {
    private static int jsonCounter = 0;

    /**
     * Creates a config.json with desired parameters
     *
     * @param simDuration  duration of the simulation, [days].
     * @param creatureList creatures, [name type {Adult, Child, Animal}]
     * @param roomList     rooms, [type {Kitchen, Living Room, Bedroom, Office, Shower}]
     *
     * @return name of the generated file
     */
    public static String createJSON(int simDuration, List<String> creatureList, List<String> roomList) {
        ImmutableConfig config = new ImmutableConfig(simDuration, creatureList, roomList);
        jsonCounter++;

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String fileName = "";
        if ( !creatureList.isEmpty() && !roomList.isEmpty() && simDuration > 0 ) {
            try {
                fileName = "config" + jsonCounter + ".json";
                objectMapper.writeValue(new File(fileName), config);
            } catch (IOException e) {
                jsonCounter--;
                System.err.println("WARNING: config wasn't generated");
            }
        } else {
            System.err.println("WARNING: given configurations are not viable. Config wasn't generated");
        }

        return fileName;
    }
}
