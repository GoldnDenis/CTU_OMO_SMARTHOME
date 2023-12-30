package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

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
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        Logging.log(
                Level.INFO,
                this.toString(),
                adult.getName() ,
                "is drinking coffee."
        );
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        Logging.log(
                Level.INFO,
                this.toString(),
                child.getName() ,
                "is drinking juice."
        );

        this.breakingDownChance(30);
    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        Logging.log(
                Level.INFO,
                this.toString(),
                animal.getName() ,
                "is drinking juice."
        );

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
                        "Making morning drinks.",
                        this.toString()
                );
                this.sleep();
            }
            case WATER_SHUT_OFF -> {
                Logging.log(
                        Level.INFO,
                        "No water! Going to idle mode."
                        );
                this.sleep();
            }
            case NON_SATISFYING_TEMP -> {
                this.turnOn();
                Logging.log(
                        Level.INFO,
                        "Non satisfying temperature! Making suitable drinks.",
                        this.toString()
                );
                this.sleep();
            }
        }
    }
}
