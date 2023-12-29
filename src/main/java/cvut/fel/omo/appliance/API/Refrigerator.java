package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

import java.util.logging.Level;

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
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        Logging.log(Level.INFO, "Serving beer.", this.toString());
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        Logging.log(Level.INFO, "Serving ice cream.", this.toString());

        this.breakingDownChance(30);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.breakingDownChance(50);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        if (event == GLOBAL_EVENT.NIGHT_FELL) {
            this.sleep();
        }
    }

}
