package cvut.fel.omo.home.builder;

import cvut.fel.omo.appliance.factory.ApplianceFactory;

public class RoomDirector {
    private ApplianceFactory factory = new ApplianceFactory();

    public void buildKitchen(RoomBuilder builder) {
        builder.id(1);
        builder.type("Kitchen");
        builder.addAppliance(factory.createAppliance("Stove"));
        builder.build();
    }

}
