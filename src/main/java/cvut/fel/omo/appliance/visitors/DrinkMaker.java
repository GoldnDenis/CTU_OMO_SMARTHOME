package cvut.fel.omo.appliance.visitors;

import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;

public class DrinkMaker extends Appliance implements ApplianceVisitor {
    private static int counter = 0;

    public DrinkMaker() {
        counter++;

        this.name = "Drink Maker";
        this.consumption = new ResourceConsumption(
                APPLIANCE_CONSUMP_INFO.DRINKMAKER_ELEC_PER_SEC.getValue(),
                APPLIANCE_CONSUMP_INFO.DRINKMAKER_WATER_PER_SEC.getValue(),
                APPLIANCE_CONSUMP_INFO.DRINKMAKER_REQ_TIME.getValue());
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
