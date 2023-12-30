package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceAPI;

import cvut.fel.omo.home.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
public class Creature {
    private static int counter = 0;

    private int id;
    private String name;

    @Setter
    private int busyFor;

    @Setter
    private boolean isRepairing;

    @Setter
    private ApplianceAPI currAppliance;

    @Setter
    private Room curLocation;

    public Creature(String name) {
        counter++;

        this.id = counter;
        this.name = name;
        this.busyFor = 0;
        this.isRepairing = false;
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
