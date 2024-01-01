package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.constants.STATE_CONSUMP_PERCENTAGE;
import cvut.fel.omo.system.MessageConvertor;

public class Broken extends ApplianceState {

    public Broken(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
    }

    @Override
    public void sleep() {
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void fix() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Off(applianceAPI));
        System.out.println(applianceAPI.toString() + MessageConvertor.fixMsg());
    }


}
