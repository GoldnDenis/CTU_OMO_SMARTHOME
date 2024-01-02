package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.constants.STATE_CONSUMP_PERCENTAGE;
import cvut.fel.omo.appliance.constants.STATE_MESSAGE;

public class Broken extends ApplianceState {

    public Broken(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
        System.out.println(
                applianceAPI.toString() + " can't change the state to " + STATE_MESSAGE.IS_BROKEN
                        + ". State is already " + STATE_MESSAGE.IS_BROKEN + "."
        );
    }

    @Override
    public void sleep() {
        System.out.println(
                applianceAPI.toString() + " can't change the state to " + STATE_MESSAGE.IN_IDLE_MODE
                        + ". Appliance is in " + STATE_MESSAGE.IS_BROKEN + " state."
        );
    }

    @Override
    public void turnOn() {
        System.out.println(
                applianceAPI.toString() + " can't change the state to " + STATE_MESSAGE.TURNED_ON
                        + ". Appliance is in " + STATE_MESSAGE.IS_BROKEN + " state."
        );
    }

    @Override
    public void turnOff() {
        System.out.println(
                applianceAPI.toString() + " can't change the state to " + STATE_MESSAGE.TURNED_OFF
                        + ". Appliance is in " + STATE_MESSAGE.IS_BROKEN + " state."
        );
    }

    @Override
    public void fix() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Off(applianceAPI));
        System.out.println(applianceAPI.toString() + STATE_MESSAGE.IS_FIXED);
    }


}
