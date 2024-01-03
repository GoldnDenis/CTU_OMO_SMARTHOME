package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.API.ApplianceVisitor;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.Room;
import cvut.fel.omo.system.utils.RandomGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class CreatureAPI {

    protected final Creature creature;

    @Getter
    protected String type;

    public CreatureAPI(String name) {
        this.creature = new Creature(name);
    }

    public abstract void accept(ApplianceVisitor visitor);

    public void interact(List<Room> rooms) {
        if (isBusy()) {
            accept(creature.getCurrAppliance());
            return;
        }

        List<Integer> occupiedApplianceIndices = new ArrayList<>();
        List<Integer> occupiedRoomIndices = new ArrayList<>();

        while (!isBusy()) {
            int applianceIdx = RandomGenerator.generateNumberWithout(creature.getCurLocation().getAppliancesSize(), occupiedApplianceIndices);

            Optional<ApplianceAPI> optionalAppliance = creature.getApplianceInCurRoomByIdx(applianceIdx);
            if (optionalAppliance.isPresent()) {
                ApplianceAPI appliance = optionalAppliance.get();

                if (appliance.isActive() || (appliance.isBroken() && !appliance.canFixBroken(this))) {
                    occupiedApplianceIndices.add(applianceIdx);
                    if (occupiedApplianceIndices.size() == creature.getCurLocation().getAppliancesSize()) {
                        occupiedRoomIndices.add(creature.getCurLocation().getId());

                        occupiedApplianceIndices.clear();
                        if (!changeRoomWithout(rooms, occupiedRoomIndices)) {
                            doRoutineWithoutAppliance();
                            break;
                        }
                    }
                    continue;
                }
                accept(appliance);
            }
        }
    }

    private void doRoutineWithoutAppliance() {
        String routine = type.equals("Animal") ? doAnimalRoutine() : doHumanRoutine();
        System.out.println(getName() + routine);
    }

    private String doHumanRoutine() {
        String routine;
        int activityId = RandomGenerator.generateNumber(10);
        if (activityId < 2) {
            routine = " has gone for a walk.";
        } else if (activityId < 4) {
            routine = " is riding a bicycle.";
        } else if (activityId < 6) {
            routine = " is working out.";
        } else if (activityId < 8) {
            routine = " has went for a nap.";
        } else {
            routine = " is reading a book.";
        }
        return routine;
    }

    private String doAnimalRoutine() {
        String routine;
        int activityId = RandomGenerator.generateNumber(10);
        if (activityId < 5) {
            routine = " is taking a nap.";
        } else if (activityId < 7) {
            routine = " is playing outside.";
        } else {
            routine = " is communicating with neighboring animals";
        }
        return routine;
    }

    public void move(List<Room> rooms) {
        if (isBusy()) return;

        int roomIdx = RandomGenerator.generateNumber(rooms.size());
        creature.setCurLocation(rooms.get(roomIdx));
    }

    public boolean changeRoomWithout(List<Room> rooms, List<Integer> exclude) {
        if (rooms.size() == exclude.size()) return false;

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
}
