package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.CreatureAPI;

public class LocalEventListener implements EventListener {

    private final CreatureAPI creature;

    public LocalEventListener(CreatureAPI creature) {
        this.creature = creature;
    }

    @Override
    public void update(ApplianceAPI appliance) {
        creature.accept(appliance);
    }

}
