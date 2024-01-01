package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Adult extends CreatureAPI {

    public Adult(String name, String type) {
        super(name, type);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        if (this.isBusy()) {
            if (this.isRepairing() && creature.getBusyFor() == 1) {
                creature.setRepairing(false);
                visitor.fix();
            }
            if (creature.getBusyFor() == 1) {
                visitor.sleep();
                creature.setCurrAppliance(null);
            }
            this.decrementBusyFor();
            return;
        }
        if (visitor.isBroken()) {
            creature.setRepairing(true);
            creature.setBusyFor(visitor.getTimeReqToFix());
            creature.setCurrAppliance((ApplianceAPI) visitor);
            return;
        }
        creature.setCurrAppliance((ApplianceAPI) visitor);
        creature.putUsageMap(((ApplianceAPI) visitor).getName());
        creature.setBusyFor(visitor.getRequiredTime());
        visitor.visitAdult(this);
    }
}
