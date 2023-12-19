package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.visitors.ApplianceVisitor;

public class Adult extends Creature{

    public Adult(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {

    }
}
