package cvut.fel.omo.home;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.visitorAPI.ApplianceAPI;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.home.builder.RoomBuilder;
import lombok.Getter;

import java.util.List;

@Getter
public class Room {

    private int id;

    private ROOM_TYPE type;

    private List<ApplianceAPI> appliances;
    private List<Creature> creatures;

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
