package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Adult extends CreatureAPI {

    public Adult(String name) {
        super(name);
        this.type = "Adult";
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        ApplianceAPI applianceAPI = (ApplianceAPI) visitor;
        if (this.isBusy()) {
            if (this.isRepairing() && creature.getBusyFor() == 1) {
                creature.setRepairing(false);
                applianceAPI.fix();
            }
            if (creature.getBusyFor() == 1) {
                applianceAPI.sleep();
                creature.setCurrAppliance(null);
            }
            this.decrementBusyFor();
            return;
        }
        if (applianceAPI.isBroken()) {
            creature.setRepairing(true);
            creature.setBusyFor(applianceAPI.getTimeReqToFix());
            creature.setCurrAppliance(applianceAPI);
            return;
        }
        creature.setCurrAppliance(applianceAPI);
        creature.putUsageMap(applianceAPI.getName());
        creature.setBusyFor(applianceAPI.getRequiredTime());
        visitor.visitAdult(this);
    }
}
