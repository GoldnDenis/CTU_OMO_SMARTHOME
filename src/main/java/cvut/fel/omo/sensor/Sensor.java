package cvut.fel.omo.sensor;

import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.RandomGenerator;

public class Sensor {

    public GlobalEventDetector detector;

    public Sensor() {
        this.detector = new GlobalEventDetector();
    }

    public void tryToDetect() {
        if (RandomGenerator.hasHappened(10)) {
            detector.notifyAll(GLOBAL_EVENT.ELECTRICITY_SHUT_OFF);
            System.out.println("The electricity shut off has been detected.");
            return;
        }
        if (RandomGenerator.hasHappened(10)) {
            detector.notifyAll(GLOBAL_EVENT.WATER_SHUT_OFF);
            System.out.println("The water shut off has been detected.");
        }
        if (RandomGenerator.hasHappened(10)) {
            detector.notifyAll(GLOBAL_EVENT.NON_SATISFYING_TEMP);
            System.out.println("Non satisfying temperature has been detected.");
        }
    }

    public void detectNightFall() {
        detector.notifyAll(GLOBAL_EVENT.NIGHT_FELL);
        System.out.println("Night fall has been detected.");
    }

    public void detectSunRise() {
        detector.notifyAll(GLOBAL_EVENT.SUN_HAS_RISEN_UP);
        System.out.println("Sun rise has been detected.");
    }

    @Override
    public String toString() {
        return "Global sensor";
    }

}
