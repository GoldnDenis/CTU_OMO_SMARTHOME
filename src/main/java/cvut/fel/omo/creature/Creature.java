package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.visitors.ApplianceVisitor;

import lombok.Getter;

@Getter
public abstract class Creature {
    protected static int counter = 0;

    protected int id;
    protected String name;

    protected Creature(String name) {
        counter++;

        this.id = counter;
        this.name = name;
    }

    public void printId() {
        System.out.println(toString());
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
