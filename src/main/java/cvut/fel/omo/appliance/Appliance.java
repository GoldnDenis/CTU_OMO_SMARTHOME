package cvut.fel.omo.appliance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appliance {

    private int id;
    private String name;

    private ResourceConsumption consumption;
    private Manual manual;

    public int getRequiredTime() {
        return consumption.getRequiredTime();
    }

    public void updateConsumption() {
        consumption.update();
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "name='" + name +
                ", id=" + id + '\'' +
                '}';
    }

    public double getConsumedElectricity() {return consumption.getConsumedElectricity();}

    public double getConsumedWater() {return consumption.getConsumedWater();}

    public void setConsumptionPercent(double percent) {
        consumption.setPercent(percent);
    }

    public int getTimeReqToFix() {
        return manual.getTimeReqToFix();
    }
}
