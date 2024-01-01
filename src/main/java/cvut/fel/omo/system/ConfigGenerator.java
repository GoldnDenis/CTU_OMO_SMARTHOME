package cvut.fel.omo.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigGenerator {
    private static int jsonCounter = 0;

    public static void createJSON(int simDuration, List<String> creatureList, List<String> roomList) {
        ImmutableConfig config = new ImmutableConfig(simDuration, creatureList, roomList);
        jsonCounter++;

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String fileName = "config" + jsonCounter + ".json";
        try {
            objectMapper.writeValue(new File(fileName), config);
        } catch (IOException e) {
            jsonCounter--;
            throw new RuntimeException(e);
        }
    }
}
