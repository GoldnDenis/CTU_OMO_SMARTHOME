package cvut.fel.omo;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.factory.ApplianceFactory;
import cvut.fel.omo.appliance.visitors.Computer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SmartHomeApplication {

	public static void main(String[] args) {
		ApplianceFactory factory = new ApplianceFactory();
		Optional<Appliance> pc1 = factory.createAppliance("Computer");
		Optional<Appliance> pc2 = factory.createAppliance("Computer");
		Optional<Appliance> tv = factory.createAppliance("TV");

		Optional<Appliance> ps5 = factory.createAppliance("PS5");

		List<Optional<Appliance>> list = new ArrayList<>();
		list.add(pc1);
		list.add(pc2);
		list.add(tv);
		list.add(ps5);

		for (Optional<Appliance> appliance: list) {
			appliance.ifPresent(Appliance::printId);
		}

//		System.out.println("IN-PROGRESS");
	}

}
