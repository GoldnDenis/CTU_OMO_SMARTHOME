package cvut.fel.omo.system;

import cvut.fel.omo.home.SmartHome;

public class Config {

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

    public static Config readJson(String filePath) {
        //todo
        return null;
    }

    public SmartHome setUpHome() {
        //TODO: Set up home from read json
        return null;
    }

    public int getPeriod() {
        //TODO: Idk, get some period, from somewhere
        return 0;
    }
}
