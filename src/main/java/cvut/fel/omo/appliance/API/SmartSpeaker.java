package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Manual;
import cvut.fel.omo.appliance.ResourceConsumption;
import cvut.fel.omo.appliance.constants.APPLIANCE_CONSUMP_INFO;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

import java.util.logging.Level;

public class SmartSpeaker extends ApplianceAPI {

    public SmartSpeaker() {
        super();

        appliance.setName("Smart Speaker");
        appliance.setConsumption(
                new ResourceConsumption(
                        APPLIANCE_CONSUMP_INFO.SPEAKER_ELEC_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.SPEAKER_WATER_PER_SEC.getValue(),
                        APPLIANCE_CONSUMP_INFO.SPEAKER_SESSION.getValue()
                )
        );
        appliance.setManual(new Manual(2));
    }

    @Override
    public void visitAdult(Adult adult) {
        this.turnOn();
//        Logging.log(
//                Level.INFO,
//                this.toString(),
//                adult.getName() ,
//                "is turning on classical music."
//        );
        System.out.println(this + adult.getName() + " is turning on classical music.");
    }

    @Override
    public void visitChild(Child child) {
        this.turnOn();
        Logging.log(
                Level.INFO,
                this.toString(),
                child.getName() ,
                "is turning on rock music."
        );

        this.breakingDownChance(30, child);

    }

    @Override
    public void visitAnimal(Animal animal) {
        this.turnOn();
        Logging.log(
                Level.INFO,
                this.toString(),
                animal.getName() ,
                "is turning on nature sounds."
        );

        this.breakingDownChance(50, animal);
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
                        "Playing the morning alarm."
                );
                this.sleep();
            }
        }
    }
}
