package cvut.fel.omo;

import cvut.fel.omo.system.ConfigGenerator;
import cvut.fel.omo.system.Simulation;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SmartHomeApplication {

	public static void main(String[] args) {
        ConfigGenerator.createJSON(1, List.of("Musta Adult", "Denis Child", "Danny Animal"), List.of("Living Room", "Shower"));

		Simulation simulation = new Simulation();
		simulation.run();
	}
}
