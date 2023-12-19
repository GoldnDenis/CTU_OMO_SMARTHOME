package cvut.fel.omo.sensor;

public class Sensor {
    public GlobalEventDetector detector;

    public Sensor() {
        this.detector = new GlobalEventDetector();
    }

    public void tryToDetect() {
        /* todo: some logic of probability generation
         if some event occurs, then notify all appliances to react
         */
    }
}
