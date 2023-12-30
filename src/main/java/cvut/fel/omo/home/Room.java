package cvut.fel.omo.home;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.builder.RoomBuilder;
import lombok.Getter;

import java.util.List;

@Getter
public class Room {

    private int id;

    private ROOM_TYPE type;

    private List<ApplianceAPI> appliances;

    public Room(RoomBuilder builder) {
        this.id = builder.getId();
        this.type = builder.getType();
        this.appliances = builder.getAppliances();
    }

    public int getAppliancesSize() {
        return appliances.size();
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
