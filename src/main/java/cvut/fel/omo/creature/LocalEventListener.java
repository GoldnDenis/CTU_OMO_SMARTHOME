package cvut.fel.omo.creature;

import cvut.fel.omo.event.LOCAL_EVENT;

public class LocalEventListener implements EventListener {

    private Creature creature;

    public LocalEventListener(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void update(LOCAL_EVENT event) {
        switch (event) {
            case APPLIANCE_HAS_BROKEN_DOWN -> {
                // todo: some reaction
            }
            case APPLIANCE_HAS_FINISHED_JOB -> {
                // todo: some reaction
            }
        }
    }

}
