package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

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
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        Logging.log(Level.INFO, "Preparing steak.", this.toString());
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        Logging.log(Level.INFO, "Preparing chicken nuggets", this.toString());

        this.breakingDownChance(30);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.sleep();

        this.breakingDownChance(50);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NIGHT_FELL
                    -> this.turnOff();
            case SUN_HAS_RISEN_UP
                    -> this.sleep();
            case WATER_SHUT_OFF -> {
                Logging.log(
                        Level.INFO,
                        "Not enough water! Going to idle mode.",
                        this.toString()
                );
                this.sleep();
            }
            case NON_SATISFYING_TEMP -> {
                Logging.log(
                        Level.INFO,
                        "Non satisfying temperature! Going to idle mode.",
                        this.toString()
                );
                this.sleep();
            }
        }
    }
}
