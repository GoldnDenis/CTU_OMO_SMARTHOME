package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdultTest {
    Adult adult;
    Computer computer;

    @BeforeEach
    void setUpAdult() {
        adult = new Adult("Test", "Adult");
        computer = new Computer();
    }

    @Test
    void busyForDecrementsAfterAcceptTest() {
        int timeBeforeAccept = 2;

        adult.creature.setBusyFor(timeBeforeAccept);

        adult.accept(computer);

        int timeAfterAccept = adult.creature.getBusyFor();

        assertEquals(timeBeforeAccept - 1, timeAfterAccept);
    }

    @Test
    void startRepairingTest() {
        computer.breakDown();

        adult.accept(computer);

        assertTrue(adult.isRepairing());
        assertEquals(adult.creature.getBusyFor(), computer.getTimeReqToFix());
    }

}