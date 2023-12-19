package cvut.fel.omo.appliance;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public abstract class Appliance {
    protected int id;
    protected String name;

    protected ResourceConsumption consumption;

    public void printId() {
        System.out.println(toString());
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
