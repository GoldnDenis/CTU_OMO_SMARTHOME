package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.constants.STATE_CONSUMP_PERCENTAGE;
import cvut.fel.omo.appliance.constants.STATE_MESSAGE;

public class Off extends ApplianceState {

    public Off(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Broken(applianceAPI));
        applianceAPI.notifyFirstNotBusy();
        System.out.println(applianceAPI.toString() + STATE_MESSAGE.IS_BROKEN);
    }

    @Override
    public void sleep() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.IDLE_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Active(applianceAPI));
        System.out.println(applianceAPI.toString() + STATE_MESSAGE.IN_IDLE_MODE);
    }

    @Override
    public void turnOn() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.FULL_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Active(applianceAPI));
        System.out.println(applianceAPI.toString() + STATE_MESSAGE.TURNED_ON);
    }

    @Override
    public void turnOff() {
        System.out.println(
                applianceAPI.toString() + " can't change the state to " + STATE_MESSAGE.TURNED_OFF
                        + ". State is already " + STATE_MESSAGE.TURNED_OFF + "."
        );
    }

    @Override
    public void fix() {
        System.out.println(
                applianceAPI.toString() + " can't fix the appliance. It's not in "
                        + STATE_MESSAGE.IS_BROKEN + " state."
        );
    }

}
