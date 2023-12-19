package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.ApplianceAPI;
import cvut.fel.omo.appliance.CONSUMPTION_PERCENTAGE;
import cvut.fel.omo.system.Logging;
import cvut.fel.omo.system.MessageConvertor;

import java.util.logging.Level;

public class Active extends ApplianceState {

    public Active(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
        applianceAPI.setConsumptionPercent(CONSUMPTION_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Broken(applianceAPI));
        Logging.log(Level.INFO, MessageConvertor.isBrokenMsg(applianceAPI.toSting()));
    }

    @Override
    public void sleep() {
        applianceAPI.setConsumptionPercent(CONSUMPTION_PERCENTAGE.IDLE_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Idle(applianceAPI));
        Logging.log(Level.INFO, MessageConvertor.idleMsg(applianceAPI.toSting()));
    }

    @Override
    public void turnOn() {
    }

    @Override
    public void turnOff() {
        applianceAPI.setConsumptionPercent(CONSUMPTION_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Off(applianceAPI));
        Logging.log(Level.INFO, MessageConvertor.turnOffMsg(applianceAPI.toSting()));
    }

    @Override
    public void fix() {
    }
}
