package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Animal extends CreatureAPI {

    public Animal(String name) {
        super(name);
        this.type = "Animal";
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        ApplianceAPI applianceAPI = (ApplianceAPI) visitor;
        if (this.isBusy()) {
            if (creature.getBusyFor() == 1) {
                applianceAPI.sleep();
                creature.setCurrAppliance(null);
            }
            this.decrementBusyFor();
            return;
        }
        creature.setCurrAppliance(applianceAPI);
        creature.putUsageMap(applianceAPI.getName());
        creature.setBusyFor(applianceAPI.getRequiredTime());
        visitor.visitAnimal(this);
    }
}
