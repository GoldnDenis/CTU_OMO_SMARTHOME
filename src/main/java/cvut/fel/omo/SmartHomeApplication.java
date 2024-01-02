package cvut.fel.omo;

import cvut.fel.omo.system.ConfigGenerator;
import cvut.fel.omo.system.Simulation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SmartHomeApplication {

    public static void main(String[] args) {
        /* todo: write your own desirable configurations */
        ConfigGenerator.createJSON(
        1,
        List.of("Musta Adult", "Denis Child", "Danny Animal"),
        List.of("Living Room", "Shower"));

        // todo: write here the name of an existing config file
        String configFile = "";

        Simulation simulation = new Simulation();
        simulation.run(configFile);
    }
}
