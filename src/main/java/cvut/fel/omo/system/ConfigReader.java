package cvut.fel.omo.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import cvut.fel.omo.home.SmartHome;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
//    private static Config instance;
//
//    private Config() {
//    }
//
//    public synchronized static Config getInstance() {
//        if (instance == null) {
//            instance = new Config();
//        }
//        return instance;
//    }

    private ImmutableConfig config;

    public boolean readJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            config = objectMapper.readValue(new File(filePath), ImmutableConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public SmartHome setUpHome() {
        //TODO: Set up home from read json
        return null;
    }

    public int getDuration() {
        //TODO: Idk, get some period, from somewhere
        return 0;
    }
}
