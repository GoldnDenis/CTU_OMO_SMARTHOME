package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.visitorAPI.ApplianceVisitor;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Creature {
    protected static int counter = 0;

    protected int id;
    protected String name;

    @Setter
    protected Boolean isBusy;

    protected Creature(String name) {
        counter++;

        this.id = counter;
        this.name = name;
        this.isBusy = false;
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

    public abstract void accept(ApplianceVisitor visitor);

}
