package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.constants.STATE_CONSUMP_PERCENTAGE;
import cvut.fel.omo.system.MessageConvertor;

import java.util.logging.Level;

public class Off extends ApplianceState {

    public Off(ApplianceAPI applianceAPI) {
        super(applianceAPI);
    }

    @Override
    public void breakDown() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.NO_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Broken(applianceAPI));
        applianceAPI.notifyFirstNotBusy();
        System.out.println(applianceAPI.toString() + MessageConvertor.isBrokenMsg());
    }

    @Override
    public void sleep() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.IDLE_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Active(applianceAPI));
        System.out.println(applianceAPI.toString() + MessageConvertor.idleMsg());
    }

    @Override
    public void turnOn() {
        applianceAPI.setConsumptionPercent(STATE_CONSUMP_PERCENTAGE.FULL_CONSUMPTION.getPercent());
        applianceAPI.changeState(new Active(applianceAPI));
        System.out.println(applianceAPI.toString() + MessageConvertor.turnOnMsg());
    }

    @Override
    public void turnOff() {
    }

    @Override
    public void fix() {
    }

}
