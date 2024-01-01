package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceAPI;

import cvut.fel.omo.home.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class Creature {
    private static int counter = 0;

    private final int id;
    private final String name;
    private final String type;

    private Map<String, Integer> usageMap;

    @Setter
    private int busyFor;

    @Setter
    private boolean isRepairing;

    @Setter
    private ApplianceAPI currAppliance;

    @Setter
    private Room curLocation;

    public Creature(String name, String type) {
        counter++;

        this.id = counter;
        this.name = name;
        this.type = type;
        this.busyFor = 0;
        this.isRepairing = false;
        this.usageMap = new HashMap<>();
    }

    public void putUsageMap(String key) {
        if ( usageMap.containsKey(key) ) {
            int count = usageMap.get(key);
            usageMap.put(key, ++count);
        } else {
            usageMap.put(key, 1);
        }
    }

    public int getApplianceNumInRoom() {
        return curLocation.getAppliancesSize();
    }

    public Optional<ApplianceAPI> getApplianceInCurRoomByIdx(int idx) {
        if ( idx > curLocation.getAppliancesSize() || idx < 0 ) return Optional.empty();
        return Optional.of(curLocation.getAppliances().get(idx));
    }

    public void printId() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
