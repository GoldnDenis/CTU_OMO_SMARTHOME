package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.event.LOCAL_EVENT;

public interface EventListener {

    void update(LOCAL_EVENT event, ApplianceAPI appliance);


}
