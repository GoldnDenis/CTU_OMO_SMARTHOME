package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Manual;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;

import java.util.logging.Level;

public class DrinkMaker extends ApplianceAPI {

    public DrinkMaker() {
        super();

        appliance.setName("Drink Maker");
        appliance.setConsumption(
                new ResourceConsumption(
                        APPLIANCE_CONSUMP_INFO.DRINKMAKER_ELEC_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.DRINKMAKER_WATER_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.DRINKMAKER_REQ_TIME.getValue()
                )
        );
        appliance.setManual(new Manual(3));
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        System.out.println(this + adult.getName() + " is drinking coffee.");
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        System.out.println(this + child.getName() + " is drinking juice.");
        this.breakingDownChance(15, child);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        System.out.println(this + animal.getName() + " is drinking water.");
        this.breakingDownChance(30, animal);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NIGHT_FELL
                    -> this.turnOff();
            case SUN_HAS_RISEN_UP -> {
                this.turnOn();
                System.out.println(toString() + " is preparing morning drinks.");
                this.sleep();
            }
            case WATER_SHUT_OFF -> {
                System.out.println("Running low on water! Going idle until restored.");
                this.sleep();
            }
            case NON_SATISFYING_TEMP -> {
                this.turnOn();
                System.out.println("Temperature is abnormal! Preparing suitable drinks.");
                this.sleep();
            }
        }
    }
}
