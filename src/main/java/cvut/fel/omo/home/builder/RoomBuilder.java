package cvut.fel.omo.home.builder;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.home.Room;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class RoomBuilder {

    private int id;

    private String type;

    private List<Appliance> appliances;

    public RoomBuilder() {
        appliances = new ArrayList<>();
    }


    public void id(int id) {
        this.id = id;
    }

    public void type(String type) {
        this.type = type;
    }

    public void addAppliance(Optional<Appliance> appliance) {
        appliance.ifPresent(value -> this.appliances.add(value));
    }

    public Room build() {
        return new Room(this);
    }
}
