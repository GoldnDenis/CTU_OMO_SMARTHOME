package cvut.fel.omo.appliance;

import cvut.fel.omo.event.GLOBAL_EVENT;

public class GlobalEventListener {
    private ApplianceAPI appliance;

    public GlobalEventListener(ApplianceAPI appliance) {
        this.appliance = appliance;
    }

    public void reactToEvent(GLOBAL_EVENT event) {
        if (event.equals(GLOBAL_EVENT.ELECTRICITY_SHUT_OFF)) {
            // todo: some reaction - off
        } else if (event.equals(GLOBAL_EVENT.WATER_SHUT_OFF)) {
            // todo: some reaction - idle
        }
    }
}
