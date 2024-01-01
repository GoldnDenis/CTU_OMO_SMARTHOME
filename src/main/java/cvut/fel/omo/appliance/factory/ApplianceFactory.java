package cvut.fel.omo.appliance.factory;

import cvut.fel.omo.appliance.API.*;

import java.util.Optional;

public class ApplianceFactory {
    public Optional<ApplianceAPI> createAppliance(String type) {
        ApplianceAPI appliance = null;

        switch (type) {
            case "Computer" -> appliance = new Computer();
            case "Drink Maker" -> appliance = new DrinkMaker();
            case "Food Dispenser" -> appliance = new FoodDispenser();
            case "Refrigerator" -> appliance = new Refrigerator();
            case "Smart Speaker" -> appliance = new SmartSpeaker();
            case "Stove" -> appliance = new Stove();
            case "TV" -> appliance = new TV();
            default -> System.err.println(type + " is not a viable appliance");
        }

        return Optional.ofNullable(appliance);
    }
}
