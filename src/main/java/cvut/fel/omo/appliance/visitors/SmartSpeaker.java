package cvut.fel.omo.appliance.visitors;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;

public class SmartSpeaker extends Appliance implements ApplianceVisitor {
    @Override
    public void visitAdult(Adult adult) {

    }

    @Override
    public void visitChild(Child child) {

    }

    @Override
    public void visitAnimal(Animal animal) {

    }
}
