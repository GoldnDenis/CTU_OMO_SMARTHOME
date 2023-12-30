package cvut.fel.omo;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.factory.ApplianceFactory;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.creature.factory.CreatureFactory;
import cvut.fel.omo.system.ConfigGenerator;
import cvut.fel.omo.system.Logging;
import cvut.fel.omo.system.Simulation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@SpringBootApplication
public class SmartHomeApplication {

	public static void main(String[] args) {
//        ConfigGenerator.createJSON(3, List.of("Musta Adult", "Denis Adult", "Jiri Adult", "Bonnie Adult"), List.of("Kitchen", "Living Room"));

		Simulation simulation = new Simulation();
		simulation.run();
	}
}
