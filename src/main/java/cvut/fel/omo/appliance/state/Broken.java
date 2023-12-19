package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.ApplianceAPI;

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
        applianceAPI.changeState(new Off(applianceAPI));
    }


}
