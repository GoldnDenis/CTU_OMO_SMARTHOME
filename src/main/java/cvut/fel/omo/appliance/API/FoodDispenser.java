package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Manual;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;

public class FoodDispenser extends ApplianceAPI {

    public FoodDispenser() {
        super();

        appliance.setName("Food Dispenser");
        appliance.setConsumption(
                new ResourceConsumption(
                        APPLIANCE_CONSUMP_INFO.FOODDISP_ELEC_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.FOODDISP_WATER_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.FOODDISP_REQ_TIME.getValue()
                )
        );
        appliance.setManual(new Manual(3));
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        System.out.println(this + adult.getName() + " is having a nice meal.");
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        System.out.println(this + child.getName() + " is snacking on some chips.");

        this.breakingDownChance(30, child);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        System.out.println(this + animal.getName() + " is eating an animal food.");

        this.breakingDownChance(50, animal);

    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NIGHT_FELL -> this.turnOff();
            case SUN_HAS_RISEN_UP -> {
                this.turnOn();
                System.out.println("Serving breakfast.");
                this.sleep();
            }
            case WATER_SHUT_OFF -> {
                System.out.println("Running low on water! Going idle until restored.");
                this.sleep();
            }
        }
    }
}
