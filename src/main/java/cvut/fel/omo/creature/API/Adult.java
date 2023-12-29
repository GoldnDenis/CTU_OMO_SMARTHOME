package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;
import cvut.fel.omo.creature.API.CreatureAPI;

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
            this.decrementBusyFor();
            return;
        }
        if (visitor.isBroken()) {
            creature.setBusyFor(2);
            creature.setFixingAppliance((ApplianceAPI) visitor);
            return;
        }
        creature.setBusyFor(visitor.getRequiredTime());
        visitor.visitAdult(this);
    }
}
