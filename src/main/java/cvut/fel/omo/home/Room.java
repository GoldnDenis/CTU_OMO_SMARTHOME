package cvut.fel.omo.home;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.home.builder.RoomBuilder;
import lombok.Getter;

import java.util.List;

@Getter
public class Room {

    private final int id;
    private final String name;

    private final ROOM_TYPE type; // todo:: check if necessary

    private final List<ApplianceAPI> appliances;

    public Room(RoomBuilder builder) {
        this.id = builder.getId();
        this.name = builder.getName();
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
