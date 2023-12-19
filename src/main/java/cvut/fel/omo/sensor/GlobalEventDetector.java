package cvut.fel.omo.sensor;

import cvut.fel.omo.appliance.GlobalEventListener;
import cvut.fel.omo.event.GLOBAL_EVENT;

import java.util.ArrayList;
import java.util.List;

public class GlobalEventDetector {
    private final List<GlobalEventListener> listeners;

    public GlobalEventDetector() {
        this.listeners = new ArrayList<>();
    }

    public void attach(GlobalEventListener appliance) {
        listeners.add(appliance);
    }

    public void detach(GlobalEventListener appliance) {
        listeners.add(appliance);
    }

    public void notifyAll(GLOBAL_EVENT event) {
        listeners.forEach(listener -> listener.reactToEvent(event));
    }
}
