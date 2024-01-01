package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Manual;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;

public class Refrigerator extends ApplianceAPI {

    public Refrigerator() {
        super();

        appliance.setName("Refrigerator");
        appliance.setConsumption(
                new ResourceConsumption(
                        APPLIANCE_CONSUMP_INFO.FRIDGE_ELEC_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.FRIDGE_WATER_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.FRIDGE_SESSION.getValue()
                )
        );
        appliance.setManual(new Manual(5));
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        System.out.println(this + adult.getName() + " is getting a bottle of beer.");
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        System.out.println(this + child.getName() + " is getting an ice cream.");
        this.breakingDownChance(30, child);

    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        System.out.println(this + animal.getName() + " is playing with the fridge's door.");
        this.breakingDownChance(50, animal);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        if (event == GLOBAL_EVENT.NIGHT_FELL) {
            this.sleep();
        }
    }

}
