package cvut.fel.omo.appliance.factory;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ApplianceFactoryTest {

    static ApplianceFactory factory;

    @BeforeAll
    static void setUpFactory() {
        factory = new ApplianceFactory();
    }

    @Test
    void wrongInputTest() {
        String wrongInput = "Cumputer";

        Optional<ApplianceAPI> applianceAPI = factory.createAppliance(wrongInput);

        assertNull(applianceAPI.orElse(null));
    }

    @Test
    void createComputersWithDifferentIdsTest() {
        String computerStr = "Computer";

        ApplianceAPI computer1 = factory.createAppliance(computerStr).get();
        ApplianceAPI computer2 = factory.createAppliance(computerStr).get();

        assertEquals(computer1.getName(), computer2.getName());
        assertNotEquals(computer1.getId(), computer2.getId());
    }



}