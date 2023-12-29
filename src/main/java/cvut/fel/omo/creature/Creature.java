package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.API.ApplianceVisitor;

import cvut.fel.omo.home.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Creature {
    protected static int counter = 0;

    protected int id;
    protected String name;

    @Setter
    protected Boolean isBusy;
    @Getter
    protected Room curLocation;

    protected Creature(String name) {
        counter++;

        this.id = counter;
        this.name = name;
        this.isBusy = false;
    }

    public void changeRoom() {}

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

    public abstract void accept(ApplianceVisitor visitor);

}
