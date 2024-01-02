package cvut.fel.omo.sensor;

import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.event.GlobalEventAccumulator;
import cvut.fel.omo.system.RandomGenerator;

import java.util.Optional;

public class Sensor {

    private final GlobalEventDetector detector;
    private final GlobalEventAccumulator accumulator;

    public Sensor() {
        this.detector = new GlobalEventDetector();
        this.accumulator = new GlobalEventAccumulator();
    }

    public void tryToDetectGlobalEvent() {
        generateGlobalEvent().ifPresent(this::notifyGlobalEvent);
    }

    private Optional<GLOBAL_EVENT> generateGlobalEvent() {
        if (RandomGenerator.hasHappened(90)) {
            return Optional.of(GLOBAL_EVENT.ELECTRICITY_SHUT_OFF);
        }
        if (RandomGenerator.hasHappened(90)) {
            return Optional.of(GLOBAL_EVENT.WATER_SHUT_OFF);
        }
        if (RandomGenerator.hasHappened(90)) {
            return Optional.of(GLOBAL_EVENT.NON_SATISFYING_TEMP);
        }
        return Optional.empty();
    }

    private void notifyGlobalEvent(GLOBAL_EVENT event) {
        detector.notifyAll(event);
        accumulator.accumulateGlobalEvent(event);
    }

    public void detectNightFall() {
        notifyGlobalEvent(GLOBAL_EVENT.NIGHT_FELL);
        System.out.println("Night fall has been detected.");
    }

    public void detectSunRise() {
        notifyGlobalEvent(GLOBAL_EVENT.SUN_HAS_RISEN_UP);
        System.out.println("Sun rise has been detected.");
    }

    public void attach(GlobalEventListener appliance) {
        detector.attach(appliance);
    }

}
