package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

import java.util.logging.Level;

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
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        Logging.log(Level.INFO, "Serving big portion.", this.toString());
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        Logging.log(Level.INFO, "Serving small portion.", this.toString());

        this.breakingDownChance(30);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        Logging.log(Level.INFO, "Serving animal food.", this.toString());

        this.breakingDownChance(50);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NIGHT_FELL
                    -> this.turnOff();
            case SUN_HAS_RISEN_UP -> {
                this.turnOn();
                Logging.log(
                        Level.INFO,
                        "Serving breakfast.",
                        this.toString()
                );
                this.sleep();
            }
            case WATER_SHUT_OFF -> {
                Logging.log(
                        Level.INFO,
                        "Not enough water! Going to idle mode.",
                        this.toString()
                );
                this.sleep();
            }
        }
    }
}
