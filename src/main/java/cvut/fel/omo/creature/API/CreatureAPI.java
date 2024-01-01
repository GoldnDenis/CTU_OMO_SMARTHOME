package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.Room;
import cvut.fel.omo.system.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class CreatureAPI {

    @Getter
    protected final Creature creature;

    public CreatureAPI(String name, String type) {
        this.creature = new Creature(name, type);
    }

    public abstract void accept(ApplianceVisitor visitor);

    public void interact(List<Room> rooms) {
        List<Integer> occupiedApplianceIndices = new ArrayList<>();
        List<Integer> occupiedRoomIndices = new ArrayList<>();

        if ( isBusy() ) {
            accept(getCreature().getCurrAppliance());
            return;
        }

        while ( !isBusy() ) {
            int applianceIdx = RandomGenerator.generateNumberWithout(creature.getCurLocation().getAppliancesSize(), occupiedApplianceIndices);

            Optional<ApplianceAPI> optionalAppliance = creature.getApplianceInCurRoomByIdx(applianceIdx);
            if ( optionalAppliance.isPresent() ) {
                ApplianceAPI appliance = optionalAppliance.get();

                if ( !appliance.isAvailable() ) {
                    occupiedApplianceIndices.add(applianceIdx);
                    if ( occupiedApplianceIndices.size() == creature.getCurLocation().getAppliancesSize() ) {
                        occupiedRoomIndices.add(creature.getCurLocation().getId());
                        if ( !changeRoomWithout(rooms, occupiedRoomIndices)) break;
                    }
                } else {
                    accept(appliance);
                }
            }
        }
    }

    public void move(List<Room> rooms) {
        if ( isBusy() ) return;

        int roomIdx = RandomGenerator.generateNumber(rooms.size());
        creature.setCurLocation(rooms.get(roomIdx));
    }

    public boolean changeRoomWithout(List<Room> rooms, List<Integer> exclude) {
        if ( rooms.size() == exclude.size() ) return false;

        int roomIdx = RandomGenerator.generateNumberWithout(rooms.size(), exclude);
        creature.setCurLocation(rooms.get(roomIdx));

        return true;
    }

    public Map<String, Integer> getUsageMap() {
        return creature.getUsageMap();
    }

    public boolean isBusy() {
        return creature.getBusyFor() > 0;
    }

    public void decrementBusyFor() {
        creature.setBusyFor(creature.getBusyFor() - 1);
    }

    public boolean isRepairing() {
        return creature.isRepairing();
    }

    @Override
    public String toString() {
        return this.creature.toString();
    }

    public String getName() {
        return creature.getName();
    }
    public String getType() {return creature.getType();}
}
