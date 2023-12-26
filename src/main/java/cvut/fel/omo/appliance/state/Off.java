package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.visitorAPI.ApplianceAPI;
import cvut.fel.omo.appliance.constants.STATE_CONSUMP_PERCENTAGE;
import cvut.fel.omo.system.Logging;
import cvut.fel.omo.system.MessageConvertor;

import java.util.logging.Level;

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
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.FULL_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Active(applianceAPI));
        Logging.log(Level.INFO, MessageConvertor.turnOnMsg(applianceAPI.toSting()));
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void fix() {
    }

}
