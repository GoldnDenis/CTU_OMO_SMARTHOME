package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.event.LOCAL_EVENT;

public class LocalEventListener implements EventListener {

    private CreatureAPI creature;

    public LocalEventListener(CreatureAPI creature) {
        this.creature = creature;
    }

    @Override
    public void update(LOCAL_EVENT event, ApplianceAPI appliance) {
        switch (event) {
            case APPLIANCE_HAS_BROKEN_DOWN -> {
                creature.accept(appliance);
            }
            case APPLIANCE_HAS_FINISHED_JOB -> {
                // todo: some reaction
            }
        }
    }

}
