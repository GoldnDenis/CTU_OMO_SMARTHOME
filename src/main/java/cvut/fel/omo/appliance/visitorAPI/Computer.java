package cvut.fel.omo.appliance.visitorAPI;

import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;

public class Computer extends ApplianceAPI implements ApplianceVisitor {

    public Computer() {
        super();

        appliance.setName("Computer");
        appliance.setConsumption(
                new ResourceConsumption(
                        APPLIANCE_CONSUMP_INFO.COMPUTER_ELEC_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.COMPUTER_WATER_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.COMPUTER_SESSION.getValue()
                )
        );
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
