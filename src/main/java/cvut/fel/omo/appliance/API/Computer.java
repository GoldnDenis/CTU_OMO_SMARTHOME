package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

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
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
        Logging.log(
                Level.INFO,
                this.toString(),
                adult.getName() ,
                "is launching work application."
        );
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        Logging.log(
                Level.INFO,
                this.toString(),
                child.getName() ,
                "is launching game."
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
                "is playing"
        );
        this.breakingDownChance(50);
    }

    @Override
    public void react(GLOBAL_EVENT event) {
        switch (event) {
            case NON_SATISFYING_TEMP -> {
                Logging.log(
                        Level.INFO,
                        "Overheating! going to idle mode!",
                        this.toString()
                );
                this.sleep();
            }
            case NIGHT_FELL
                    -> this.turnOff();
            case SUN_HAS_RISEN_UP
                    -> this.sleep();
        }
    }

}
