package cvut.fel.omo.appliance.visitors;

import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;

public class Stove extends Appliance implements ApplianceVisitor {
    private static int counter = 0;

    public Stove() {
        counter++;

        this.name = "Stove";
        this.consumption = new ResourceConsumption(
                APPLIANCE_CONSUMP_INFO.STOVE_ELEC_PER_SEC.getValue(),
                APPLIANCE_CONSUMP_INFO.STOVE_WATER_PER_SEC.getValue(),
                APPLIANCE_CONSUMP_INFO.STOVE_SESSION.getValue());
        this.id = counter;
    }

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
