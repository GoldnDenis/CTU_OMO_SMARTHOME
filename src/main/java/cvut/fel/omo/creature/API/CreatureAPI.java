package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceVisitor;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.Room;

public abstract class CreatureAPI {

    private final Creature creature;

    public CreatureAPI(String name) {
        this.creature = new Creature(name);
    }

    public abstract void accept(ApplianceVisitor visitor);

    public void changeLocation(Room room) {
        this.creature.setCurLocation(room);
    }

    @Override
    public String toString() {
        return this.creature.toString();
    }
}
