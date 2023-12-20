package cvut.fel.omo.creature;

import cvut.fel.omo.event.LOCAL_EVENT;

public class LocalEventListener {
    private Creature creature;

    public LocalEventListener(Creature creature) {
        this.creature = creature;
    }

    public void update(LOCAL_EVENT event) {
        if (event.equals(LOCAL_EVENT.APPLIANCE_HAS_BROKEN_DOWN)) {
            // todo: some reaction
        } else if (event.equals(LOCAL_EVENT.APPLIANCE_HAS_FINISHED_JOB)) {
            // todo: some reaction
        }
    }
}
