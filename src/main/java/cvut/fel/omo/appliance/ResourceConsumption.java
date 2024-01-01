package cvut.fel.omo.appliance;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ResourceConsumption {
    @Getter
    private double consumedElectricity;
    @Getter
    private double consumedWater;

    private final int requiredElectricity;
    private final int requiredWater;
    private final int requiredTime;

    public ResourceConsumption(int requiredElectricity, int requiredWater, int requiredTime) {
        this.consumedElectricity = 0;
        this.consumedWater = 0;

        this.requiredElectricity = requiredElectricity;
        this.requiredWater = requiredWater;
        this.requiredTime = requiredTime;
    }

    @Setter
    private double percent;

    public void update() {
        consumedElectricity += (requiredElectricity * percent);
        consumedWater += (requiredWater * percent);
    }
}
