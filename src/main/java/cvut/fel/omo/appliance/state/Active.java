package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.ApplianceAPI;
import cvut.fel.omo.appliance.CONSUMPTION_PERCENTAGE;

public class Active extends ApplianceState {

    public Active(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
        applianceAPI.setConsumptionPercent(CONSUMPTION_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Broken(applianceAPI));
    }

    @Override
    public void sleep() {
        applianceAPI.setConsumptionPercent(CONSUMPTION_PERCENTAGE.IDLE_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Idle(applianceAPI));
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
        applianceAPI.setConsumptionPercent(CONSUMPTION_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Off(applianceAPI));
    }

    @Override
    public void fix() {
    }
}
