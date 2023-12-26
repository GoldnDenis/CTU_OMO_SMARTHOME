package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.visitorAPI.ApplianceAPI;
import cvut.fel.omo.appliance.constants.STATE_CONSUMP_PERCENTAGE;
import cvut.fel.omo.system.Logging;
import cvut.fel.omo.system.MessageConvertor;

import java.util.logging.Level;

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
        Logging.log(Level.INFO, MessageConvertor.fixMsg(applianceAPI.toSting()));
    }


}
