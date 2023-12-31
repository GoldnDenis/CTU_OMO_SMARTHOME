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

    public void printId() {
        System.out.println(this);
    }

    public int getRequiredTime() {
        return consumption.getRequiredTime();
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "name='" + name +
                ", id=" + id + '\'' +
                '}';
    }

    public void setConsumptionPercent(double percent) {
        consumption.setPercent(percent);
    }

    public int getTimeReqToFix() {
        return manual.getTimeReqToFix();
    }
}
