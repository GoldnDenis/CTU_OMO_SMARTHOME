package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Animal extends CreatureAPI {

    public Animal(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        if (this.isBusy()) {
            this.decrementBusyFor();
            return;
        }
        creature.setBusyFor(visitor.getRequiredTime());
        visitor.visitAnimal(this);
    }
}
