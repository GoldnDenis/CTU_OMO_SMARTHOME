package cvut.fel.omo.appliance;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Appliance {

    private int id;
    private String name;

    private ResourceConsumption consumption;
    private Manual manual;

    private Map<String, Integer> breakDownMap;

    public void updateConsumption() {
        consumption.update();
    }

    public void putBreakDownMap(String key) {
        if (breakDownMap.containsKey(key)) {
            int count = breakDownMap.get(key);
            breakDownMap.put(key, ++count);
        } else {
            breakDownMap.put(key, 1);
        }
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "name='" + name +
                ", id=" + id + '\'' +
                '}';
    }

    public int getRequiredTime() {
        return consumption.getRequiredTime();
    }

    public double getConsumedElectricity() {
        return consumption.getConsumedElectricity();
    }

    public double getConsumedWater() {
        return consumption.getConsumedWater();
    }

    public void setConsumptionPercent(double percent) {
        consumption.setPercent(percent);
    }

    public int getTimeReqToFix() {
        return manual.getTimeReqToFix();
    }
}
