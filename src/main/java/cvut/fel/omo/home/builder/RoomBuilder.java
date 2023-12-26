package cvut.fel.omo.home.builder;

import cvut.fel.omo.appliance.visitorAPI.ApplianceAPI;
import cvut.fel.omo.home.ROOM_TYPE;
import cvut.fel.omo.home.Room;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class RoomBuilder {

    private int id;

    private ROOM_TYPE type;

    private List<ApplianceAPI> appliances;

    public RoomBuilder() {
        appliances = new ArrayList<>();
    }


    public RoomBuilder id(int id) {
        this.id = id;
        return this;
    }

    public RoomBuilder type(ROOM_TYPE type) {
        this.type = type;
        return this;
    }

    public RoomBuilder addAppliance(Optional<ApplianceAPI> appliance) {
        appliance.ifPresent(value -> this.appliances.add(value));
        return this;
    }

    public Room build() {
        return new Room(this);
    }
}
