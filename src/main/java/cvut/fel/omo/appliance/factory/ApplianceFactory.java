package cvut.fel.omo.appliance.factory;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.visitors.*;
import cvut.fel.omo.system.Logging;

import java.util.Optional;
import java.util.logging.Level;

public class ApplianceFactory {
    public Optional<Appliance> createAppliance(String type) {
        Appliance appliance = null;

        switch (type) {
            case "Computer" -> appliance = new Computer();
            case "Drink Maker" -> appliance = new DrinkMaker();
            case "Food Dispenser" -> appliance = new FoodDispenser();
            case "Refrigerator" -> appliance = new Refrigerator();
            case "Smart Speaker" -> appliance = new SmartSpeaker();
            case "Stove" -> appliance = new Stove();
            case "TV" -> appliance = new TV();
            default -> Logging.log(Level.WARNING, type + " is not a viable appliance");
        }

        return Optional.ofNullable(appliance);
    }
}
