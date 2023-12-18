package cvut.fel.omo.appliance;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourceConsumption {
    private double electricity;
    private double water;
    private double time;

    public double getElectricity(double percent) {
        return electricity * percent;
    }

    public double getWater(double percent) {
        return water * percent;
    }

    public double getTime(double percent) {
        return time * percent;
    }
}
