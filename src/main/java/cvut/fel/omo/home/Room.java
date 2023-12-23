package cvut.fel.omo.home;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.home.builder.RoomBuilder;

import java.util.List;

public class Room {

    private int id;

    private ROOM_TYPE type;

    private List<Appliance> appliances;

    public Room(RoomBuilder builder) {
        this.id = builder.getId();
        this.type = builder.getType();
        this.appliances = builder.getAppliances();
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
