package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;

import cvut.fel.omo.home.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Creature {
    private static int counter = 0;

    private int id;
    private String name;

    @Setter
    private int busyFor;

    @Setter
    private ApplianceAPI fixingAppliance;

    @Setter
    private Room curLocation;

    public Creature(String name) {
        counter++;

        this.id = counter;
        this.name = name;
        this.busyFor = 0;
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
