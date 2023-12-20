package cvut.fel.omo;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.factory.ApplianceFactory;
import cvut.fel.omo.appliance.visitors.Computer;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.creature.factory.CreatureFactory;
import cvut.fel.omo.system.Logging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@SpringBootApplication
public class SmartHomeApplication {

	public static void main(String[] args) {
		CreatureFactory factory = new CreatureFactory();
		Optional<Creature> adult1 = factory.createCreature("Adult", "Marek");
		Optional<Creature> adult2 = factory.createCreature("Adult", "John");
		Optional<Creature> child = factory.createCreature("Child", "Denis");

		Optional<Creature> monster = factory.createCreature("Monster", "Sullivan");

		List<Optional<Creature>> list = new ArrayList<>();
		list.add(adult1);
		list.add(adult2);
		list.add(child);
		list.add(monster);

		for (Optional<Creature> creature: list) {
			creature.ifPresent(Creature::printId);
		}
	}
}
