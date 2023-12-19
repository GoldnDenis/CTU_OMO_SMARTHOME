package cvut.fel.omo.appliance.visitors;

import cvut.fel.omo.appliance.APPLIANCE_CONSUMPTION;
import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;

public class FoodDispenser extends Appliance implements ApplianceVisitor {
    private static int counter = 0;

    public FoodDispenser() {
        counter++;

        this.name = "Food Dispenser";
        this.consumption = new ResourceConsumption(APPLIANCE_CONSUMPTION.FOODDISP_ELEC_PER_SEC.getValue(), APPLIANCE_CONSUMPTION.FOODDISP_WATER_PER_SEC.getValue());
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
