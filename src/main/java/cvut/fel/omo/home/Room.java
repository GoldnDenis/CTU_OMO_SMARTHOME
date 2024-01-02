package cvut.fel.omo.home;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.home.builder.RoomBuilder;
import lombok.Getter;

import java.util.List;

@Getter
public class Room {

    private final int id;

    private final List<ApplianceAPI> appliances;

    public Room(RoomBuilder builder) {
        this.id = builder.getId();
        this.appliances = builder.getAppliances();
    }

    public int getAppliancesSize() {
        return appliances.size();
    }

}
