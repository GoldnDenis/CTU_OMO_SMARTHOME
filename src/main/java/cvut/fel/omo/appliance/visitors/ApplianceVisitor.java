package cvut.fel.omo.appliance.visitors;

import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;

public interface ApplianceVisitor {

    void visitAdult(Adult adult);

    void visitChild(Child child);

    void visitAnimal(Animal animal);

}
