package cvut.fel.omo.home.builder;

import cvut.fel.omo.appliance.factory.ApplianceFactory;
import cvut.fel.omo.home.ROOM_TYPE;
import cvut.fel.omo.home.Room;

public class RoomDirector {
    private int counter = 0;
    private final ApplianceFactory factory = new ApplianceFactory();

    public Room buildKitchen(RoomBuilder builder) {
        return builder
                .id(counter++)
                .type(ROOM_TYPE.KITCHEN)
                .name("Kitchen")
                .addAppliance(factory.createAppliance("Stove"))
                .addAppliance(factory.createAppliance("Drink Maker"))
                .addAppliance(factory.createAppliance("Refrigerator"))
                .addAppliance(factory.createAppliance("Food Dispenser"))
                .build();
    }

    public Room buildLivingRoom(RoomBuilder builder) {
        return builder
                .id(counter++)
                .type(ROOM_TYPE.LIVING_ROOM)
                .name("Living Room")
                .addAppliance(factory.createAppliance("TV"))
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .build();
    }

    public Room buildOffice(RoomBuilder builder) {
        return builder
                .id(counter++)
                .type(ROOM_TYPE.OFFICE)
                .name("Office")
                .addAppliance(factory.createAppliance("Computer"))
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .build();
    }

    public Room buildBedroom(RoomBuilder builder) {
        return builder
                .id(counter++)
                .type(ROOM_TYPE.BEDROOM)
                .name("Bedroom")
                .addAppliance(factory.createAppliance("TV"))
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .addAppliance(factory.createAppliance("Computer"))
                .build();
    }

    public Room Shower(RoomBuilder builder) {
        return builder
                .id(counter++)
                .type(ROOM_TYPE.SHOWER)
                .name("Shower")
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .build();
    }

}
