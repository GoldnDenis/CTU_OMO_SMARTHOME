package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceVisitor;

public class Animal extends Creature{

    public Animal(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {

    }

}
