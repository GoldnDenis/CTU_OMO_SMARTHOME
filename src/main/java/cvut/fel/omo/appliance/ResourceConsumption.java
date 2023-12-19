package cvut.fel.omo.appliance;

import lombok.Setter;

public class ResourceConsumption {
    private double consumedElectricity;
    private double consumedWater;
    private double consumedTime;

    private final int requiredElectricity;
    private final int requiredWater;
    private final int requiredTime;

    public ResourceConsumption(int requiredElectricity, int requiredWater, int requiredTime) {
        this.consumedElectricity = 0;
        this.consumedWater = 0;
        this.consumedTime = 0;

        this.requiredElectricity = requiredElectricity;
        this.requiredWater = requiredWater;
        this.requiredTime = requiredTime;
    }

    @Setter
    private double percent;

    public void update(int secondsElapsed) {
        consumedTime += secondsElapsed;
        consumedElectricity += secondsElapsed * (requiredElectricity * percent);
        consumedWater += secondsElapsed * (requiredWater * percent);
    }
}
