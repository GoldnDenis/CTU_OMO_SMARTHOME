package cvut.fel.omo.appliance;

import cvut.fel.omo.creature.LocalEventListener;
import cvut.fel.omo.event.LOCAL_EVENT;

import java.util.ArrayList;
import java.util.List;

public class LocalEventDetector {
    private final List<LocalEventListener> listeners;

    public LocalEventDetector() {
        this.listeners = new ArrayList<>();
    }

    public void attach(LocalEventListener listener) {
        listeners.add(listener);
    }

    public void detach(LocalEventListener listener) {
        listeners.add(listener);
    }

    public void notifyAll(LOCAL_EVENT event) {
        listeners.forEach(listener -> listener.update(event));
    }
}
