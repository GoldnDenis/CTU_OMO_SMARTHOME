package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Child extends CreatureAPI{

    public Child(String name) {
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
            }
            this.decrementBusyFor();
            return;
        }
        creature.setBusyFor(visitor.getRequiredTime());
        visitor.visitChild(this);
    }

}
