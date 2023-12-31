package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Animal extends CreatureAPI {

    public Animal(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        if (!visitor.isAvailable()) {
            return;
        }
        if (this.isBusy()) {
            if (creature.getBusyFor() == 1) {
                visitor.sleep();
                creature.setCurrAppliance(null);
            }
            this.decrementBusyFor();
            return;
        }
        creature.setCurrAppliance((ApplianceAPI) visitor);
        creature.putUsageMap(((ApplianceAPI) visitor).getName());
        creature.setBusyFor(visitor.getRequiredTime());
        visitor.visitAnimal(this);
    }
}
