package cvut.fel.omo.appliance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Appliance {

    protected int id;
    protected String name;

    protected ResourceConsumption consumption;

    public void printId() {
        System.out.println(toString());
    }

    public int getRequiredTime() {
        return consumption.getRequiredTime();
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setConsumptionPercent(double percent) {
        consumption.setPercent(percent);
    }
}
