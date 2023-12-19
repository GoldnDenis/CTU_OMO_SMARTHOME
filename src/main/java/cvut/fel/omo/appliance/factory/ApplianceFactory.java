package cvut.fel.omo.appliance.factory;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.visitors.*;

import java.util.Optional;

public class ApplianceFactory {
    public Optional<Appliance> createAppliance(String name) {
        Appliance appliance = null;

        switch (name) {
            case "Computer" -> appliance = new Computer();
            case "Drink Maker" -> appliance = new DrinkMaker();
            case "Food Dispenser" -> appliance = new FoodDispenser();
            case "Refrigerator" -> appliance = new Refrigerator();
            case "Smart Speaker" -> appliance = new SmartSpeaker();
            case "Stove" -> appliance = new Stove();
            case "TV" -> appliance = new TV();
            default -> {
                // log that an appliance with the name doesn't exist
            }
        }

        return Optional.ofNullable(appliance);
    }
}
