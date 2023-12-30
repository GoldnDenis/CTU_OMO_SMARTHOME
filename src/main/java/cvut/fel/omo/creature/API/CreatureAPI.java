package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.Room;
import cvut.fel.omo.system.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public abstract class CreatureAPI {
    @Getter

    protected final Creature creature;

    public CreatureAPI(String name) {
        this.creature = new Creature(name);
    }

    public abstract void accept(ApplianceVisitor visitor);

    public void interact(List<Room> rooms) {
        List<Integer> occupiedApplianceIndices = new ArrayList<>();
        List<Integer> occupiedRoomIndices = new ArrayList<>();

        while ( true ) {
            int applianceIdx = RandomGenerator.generateNumberWithout(creature.getCurLocation().getAppliancesSize() - 1, occupiedApplianceIndices);
            if ( creature.getApplianceInCurRoomByIdx(applianceIdx).isPresent() ) {
                ApplianceAPI appliance = creature.getApplianceInCurRoomByIdx(applianceIdx).get();

                if ( !appliance.isAvailable() ) {
                    occupiedApplianceIndices.add(applianceIdx);
                    if ( occupiedApplianceIndices.size() == creature.getCurLocation().getAppliancesSize() ) {
                        occupiedRoomIndices.add(creature.getCurLocation().getId());
                        if ( !changeRoomWithout(rooms, occupiedRoomIndices)) break;
                    }
                    continue;
                }

                accept(appliance);
                break;
            }
        }
    }

    public void move(List<Room> rooms) {
        if ( isBusy() ) return;

        int roomIdx = RandomGenerator.generateNumber(rooms.size() - 1);
        creature.setCurLocation(rooms.get(roomIdx));
    }

    public boolean changeRoomWithout(List<Room> rooms, List<Integer> exclude) {
        if ( rooms.size() == exclude.size() ) return false;

        int roomIdx = RandomGenerator.generateNumberWithout(rooms.size() - 1, exclude);
        creature.setCurLocation(rooms.get(roomIdx));

        return true;
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

    public String getName() {
        return creature.getName();
    }
}
