package cvut.fel.omo.appliance.visitors;

import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;

public interface ApplianceVisitor {

    void visitAdult(Adult adult);

    void visitChild(Child child);

    void visitAnimal(Animal animal);

}
