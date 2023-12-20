package cvut.fel.omo.home.builder;

import cvut.fel.omo.appliance.factory.ApplianceFactory;

public class RoomDirector {
    private int counter = 1;
    private ApplianceFactory factory = new ApplianceFactory();

    public void buildKitchen(RoomBuilder builder) {
        builder.id(counter++)
                .type("Kitchen")
                .addAppliance(factory.createAppliance("Stove"))
                .build();
    }

}
