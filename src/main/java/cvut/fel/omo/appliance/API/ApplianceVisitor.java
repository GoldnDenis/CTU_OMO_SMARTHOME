package cvut.fel.omo.appliance.API;

import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;

public interface ApplianceVisitor {

    void visitAdult(Adult adult);

    void visitChild(Child child);

    void visitAnimal(Animal animal);

    int getRequiredTime();

    void fix();

    void sleep();

    boolean isBroken();

    boolean isAvailable();

}
