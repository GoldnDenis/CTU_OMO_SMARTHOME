package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Manual;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;

import java.util.logging.Level;

public class Computer extends ApplianceAPI {

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
        appliance.setManual(new Manual(4));
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        System.out.println(this + adult.getName() + " is working on OMO project.");
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        System.out.println(this + child.getName() + " is playing Doom.");
        this.breakingDownChance(30, child);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        System.out.println(this + animal.getName() + " is napping on the keyboard.");
        this.breakingDownChance(50, animal);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NON_SATISFYING_TEMP -> {
                System.out.println(this + "Overheating!!! Switching to an idle mode.");
                this.sleep();
            }
            case NIGHT_FELL
                    -> this.turnOff();
            case SUN_HAS_RISEN_UP
                    -> this.sleep();
        }
    }

}
