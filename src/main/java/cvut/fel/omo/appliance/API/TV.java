package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

import java.util.logging.Level;

public class TV extends ApplianceAPI {

    public TV() {
        super();

        appliance.setName("TV");
        appliance.setConsumption(
                new ResourceConsumption(
                        APPLIANCE_CONSUMP_INFO.TV_ELEC_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.TV_WATER_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.TV_SESSION.getValue()
                )
        );
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        Logging.log(Level.INFO, "Turning on drama movie.", this.toString());
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        Logging.log(Level.INFO, "Turning on cartoon.", this.toString());

        this.breakingDownChance(30);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        Logging.log(Level.INFO, "Turning on nature footage.", this.toString());

        this.breakingDownChance(50);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NIGHT_FELL
                    -> this.turnOff();
            case SUN_HAS_RISEN_UP
                    -> this.sleep();
        }
    }
}
