package cvut.fel.omo.appliance.visitors;

import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;

public class FoodDispenser extends Appliance implements ApplianceVisitor {
    private static int counter = 0;

    public FoodDispenser() {
        counter++;

        this.name = "Food Dispenser";
        this.consumption = new ResourceConsumption(
                APPLIANCE_CONSUMP_INFO.FOODDISP_ELEC_PER_SEC.getValue(),
                APPLIANCE_CONSUMP_INFO.FOODDISP_WATER_PER_SEC.getValue(),
                APPLIANCE_CONSUMP_INFO.FOODDISP_REQ_TIME.getValue());
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
