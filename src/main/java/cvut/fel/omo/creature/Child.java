package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.visitors.ApplianceVisitor;

public class Child extends Creature{

    public Child(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {

    }

}
