package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.visitorAPI.ApplianceAPI;
import cvut.fel.omo.appliance.constants.STATE_CONSUMP_PERCENTAGE;
import cvut.fel.omo.system.Logging;
import cvut.fel.omo.system.MessageConvertor;

import java.util.logging.Level;

public class Idle extends ApplianceState {

    public Idle(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Broken(applianceAPI));
        Logging.log(Level.INFO, MessageConvertor.isBrokenMsg(applianceAPI.toSting()));
    }

    @Override
    public void sleep() {
    }

    @Override
    public void turnOn() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.FULL_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Active(applianceAPI));
        Logging.log(Level.INFO, MessageConvertor.turnOnMsg(applianceAPI.toSting()));
    }

    @Override
    public void turnOff() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Off(applianceAPI));
        Logging.log(Level.INFO, MessageConvertor.turnOffMsg(applianceAPI.toSting()));
    }

    @Override
    public void fix() {
    }

}
