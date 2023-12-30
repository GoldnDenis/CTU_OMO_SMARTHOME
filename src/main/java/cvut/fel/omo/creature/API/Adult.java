package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Adult extends CreatureAPI {

    public Adult(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        if (this.isBusy()) {
            if (this.isRepairing() && creature.getBusyFor() == 1) {
                visitor.fix();
            }
            if (creature.getBusyFor() == 1) {
                visitor.sleep();
            }
            this.decrementBusyFor();
            return;
        }
        if (visitor.isBroken()) {
            creature.setBusyFor(2);
            creature.setCurrAppliance((ApplianceAPI) visitor);
            return;
        }
        creature.setBusyFor(visitor.getRequiredTime());
        visitor.visitAdult(this);
    }

}
