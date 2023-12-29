package cvut.fel.omo.sensor;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.event.GLOBAL_EVENT;

public class GlobalEventListener implements EventListener {

    private final ApplianceAPI appliance;

    public GlobalEventListener(ApplianceAPI appliance) {
        this.appliance = appliance;
    }

    @Override
    public void update(GLOBAL_EVENT event) {
        if (event == GLOBAL_EVENT.ELECTRICITY_SHUT_OFF) {
            appliance.turnOff();
        } else {
            appliance.react(event);
        }
    }

}
