package cvut.fel.omo.appliance.factory;

import cvut.fel.omo.appliance.ApplianceAPI;
import cvut.fel.omo.appliance.visitors.*;
import cvut.fel.omo.system.Logging;

import java.util.Optional;
import java.util.logging.Level;

public class ApplianceFactory {
    public Optional<ApplianceAPI> createAppliance(String type) {
        ApplianceAPI appliance = null;

        switch (type) {
            case "Computer" -> appliance = new ApplianceAPI(new Computer());
            case "Drink Maker" -> appliance = new ApplianceAPI(new DrinkMaker());
            case "Food Dispenser" -> appliance = new ApplianceAPI(new FoodDispenser());
            case "Refrigerator" -> appliance = new ApplianceAPI(new Refrigerator());
            case "Smart Speaker" -> appliance = new ApplianceAPI(new SmartSpeaker());
            case "Stove" -> appliance = new ApplianceAPI(new Stove());
            case "TV" -> appliance = new ApplianceAPI(new TV());
            default -> Logging.log(Level.WARNING, type + " is not a viable appliance");
        }

        return Optional.ofNullable(appliance);
    }
}
