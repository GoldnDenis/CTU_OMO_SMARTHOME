package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Manual;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;

import java.util.logging.Level;

public class Stove extends ApplianceAPI {

    public Stove() {
        super();

        appliance.setName("Stove");
        appliance.setConsumption(
                new ResourceConsumption(
                        APPLIANCE_CONSUMP_INFO.STOVE_ELEC_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.STOVE_WATER_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.STOVE_SESSION.getValue()
                )
        );
        appliance.setManual(new Manual(3));
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        System.out.println(this + adult.getName() + " is preparing a perfect Medium-Rare steak.");
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        System.out.println(this + child.getName() + " is preparing chicken nuggets.");
        this.breakingDownChance(30, child);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        System.out.println(this + animal.getName() + " is playing in the kitchen.");
        this.breakingDownChance(50, animal);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NIGHT_FELL
                    -> this.turnOff();
            case SUN_HAS_RISEN_UP
                    -> this.sleep();
            case WATER_SHUT_OFF -> {
                System.out.println("Running low on water! Going idle until restored.");
                this.sleep();
            }
            case NON_SATISFYING_TEMP -> {
                System.out.println("Not a suitable temperature! Going idle mode.");
                this.sleep();
            }
        }
    }
}
