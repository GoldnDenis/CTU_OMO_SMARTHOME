package cvut.fel.omo.sensor;

import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.Logging;
import cvut.fel.omo.system.RandomGenerator;
import java.util.logging.Level;

public class Sensor {

    public GlobalEventDetector detector;

    public Sensor() {
        this.detector = new GlobalEventDetector();
    }

    public void tryToDetect() {
        if (RandomGenerator.hasHappened(10)) {
            detector.notifyAll(GLOBAL_EVENT.ELECTRICITY_SHUT_OFF);
            Logging.log(
                    Level.INFO,
                    "The electricity shut off has been detected.",
                    this.toString()
            );
            return;
        }
        if (RandomGenerator.hasHappened(10)) {
            detector.notifyAll(GLOBAL_EVENT.WATER_SHUT_OFF);
            Logging.log(
                    Level.INFO,
                    "The water shut off has been detected.",
                    this.toString()
            );
        }
        if (RandomGenerator.hasHappened(10)) {
            detector.notifyAll(GLOBAL_EVENT.NON_SATISFYING_TEMP);
            Logging.log(
                    Level.INFO,
                    "Non satisfying temperature has been detected.",
                    this.toString()
            );
        }
    }

    public void detectNightFall() {
        detector.notifyAll(GLOBAL_EVENT.NIGHT_FELL);
        Logging.log(
                Level.INFO,
                "Night fall has been detected.",
                this.toString()
        );
    }

    public void detectSunRise() {
        detector.notifyAll(GLOBAL_EVENT.SUN_HAS_RISEN_UP);
        Logging.log(
                Level.INFO,
                "Sun rise has been detected.",
                this.toString()
        );
    }

    @Override
    public String toString() {
        return "Global sensor";
    }

}
