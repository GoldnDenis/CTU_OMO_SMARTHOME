package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.Room;
import cvut.fel.omo.system.RandomGenerator;

import java.util.Optional;

public abstract class CreatureAPI {

    protected final Creature creature;

    public CreatureAPI(String name) {
        this.creature = new Creature(name);
    }

    public abstract void accept(ApplianceVisitor visitor);

    public void interact() {
        int applianceId = -1;
        while (true) {
            applianceId = RandomGenerator.generateNumber(creature.getApplianceNumInRoom());
            if (creature.getApplianceById(applianceId).isPresent()) {
                ApplianceAPI appliance = creature.getApplianceById(applianceId).get();

                if ( !appliance.isActive() && !appliance.isBroken()) {
                    accept(appliance);
                }
            }

        }
    }

    public void changeLocation(Room room) {
        this.creature.setCurLocation(room);
    }

    public boolean isBusy() {
        return creature.getBusyFor() > 0;
    }

    public void decrementBusyFor() {
        creature.setBusyFor(creature.getBusyFor() - 1);
    }

    public boolean isRepairing() {
        return creature.getFixingAppliance() != null;
    }

    @Override
    public String toString() {
        return this.creature.toString();
    }
}
