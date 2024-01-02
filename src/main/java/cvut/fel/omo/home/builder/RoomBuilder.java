package cvut.fel.omo.home.builder;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.home.Room;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class RoomBuilder {

    private int id;

    private final List<ApplianceAPI> appliances;

    public RoomBuilder() {
        appliances = new ArrayList<>();
    }


    public RoomBuilder id(int id) {
        this.id = id;
        return this;
    }


    public RoomBuilder addAppliance(Optional<ApplianceAPI> appliance) {
        appliance.ifPresent(this.appliances::add);
        return this;
    }

    public Room build() {
        return new Room(this);
    }
}
