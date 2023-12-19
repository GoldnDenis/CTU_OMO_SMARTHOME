package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.ApplianceAPI;
import cvut.fel.omo.appliance.CONSUMPTION_PERCENTAGE;

public class Off extends ApplianceState {

    public Off(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
        applianceAPI.changeState(new Broken(applianceAPI));
    }

    @Override
    public void sleep() {
    }

    @Override
    public void turnOn() {
        applianceAPI.setConsumptionPercent(CONSUMPTION_PERCENTAGE.FULL_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Active(applianceAPI));
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void fix() {
    }

}
