package cvut.fel.omo.sensor;

import cvut.fel.omo.appliance.visitorAPI.ApplianceAPI;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;

import java.util.logging.Level;

public class GlobalEventListener implements EventListener {

    private ApplianceAPI appliance;

    public GlobalEventListener(ApplianceAPI appliance) {
        this.appliance = appliance;
    }

    @Override
    public void update(GLOBAL_EVENT event) {
        switch (event) {
            case ELECTRICITY_SHUT_OFF
                    -> appliance.turnOff();
            case WATER_SHUT_OFF
                    -> appliance.sleep();
            case NIGHT_FELL -> {
                // todo: some reaction
            }
            case SUN_HAS_RISEN_UP -> {
                // todo: some reaction
            }
            case NON_SATISFYING_TEMP -> {
                // todo: some reaction
            }
        }
    }

}
