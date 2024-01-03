package cvut.fel.omo.home.builder;

import cvut.fel.omo.appliance.factory.ApplianceFactory;
import cvut.fel.omo.home.Room;

public class RoomDirector {
    private int counter = 0;
    private final ApplianceFactory factory = new ApplianceFactory();

    public Room buildKitchen(RoomBuilder builder) {
        return builder
                .id(counter++)
                .addAppliance(factory.createAppliance("Stove"))
                .addAppliance(factory.createAppliance("Drink Maker"))
                .addAppliance(factory.createAppliance("Refrigerator"))
                .addAppliance(factory.createAppliance("Food Dispenser"))
                .build();
    }

    public Room buildLivingRoom(RoomBuilder builder) {
        return builder
                .id(counter++)
                .addAppliance(factory.createAppliance("TV"))
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .build();
    }

    public Room buildOffice(RoomBuilder builder) {
        return builder
                .id(counter++)
                .addAppliance(factory.createAppliance("Computer"))
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .build();
    }

    public Room buildBedroom(RoomBuilder builder) {
        return builder
                .id(counter++)
                .addAppliance(factory.createAppliance("TV"))
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .addAppliance(factory.createAppliance("Computer"))
                .build();
    }

    public Room buildShower(RoomBuilder builder) {
        return builder
                .id(counter++)
                .addAppliance(factory.createAppliance("Smart Speaker"))
                .build();
    }

}
