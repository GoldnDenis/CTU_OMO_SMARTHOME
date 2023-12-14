package cvut.fel.omo.system;

public class Config {

    private static Config instance;

    private Config() {
    }

    public synchronized static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }


}
