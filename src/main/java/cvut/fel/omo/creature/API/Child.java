package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Child extends CreatureAPI{

    public Child(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        visitor.visitChild(this);
    }

}
