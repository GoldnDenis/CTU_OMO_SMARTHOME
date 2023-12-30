package cvut.fel.omo.appliance.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum APPLIANCE_CONSUMP_INFO {
    COMPUTER_ELEC_PER_SEC(210),
    COMPUTER_WATER_PER_SEC(0),
    COMPUTER_SESSION(3),

    DRINKMAKER_ELEC_PER_SEC(50),
    DRINKMAKER_WATER_PER_SEC(11),
    DRINKMAKER_REQ_TIME(1),

    FOODDISP_ELEC_PER_SEC(20),
    FOODDISP_WATER_PER_SEC(5),
    FOODDISP_REQ_TIME(1),

    FRIDGE_ELEC_PER_SEC(100),
    FRIDGE_WATER_PER_SEC(5),
    FRIDGE_SESSION(1),

    SPEAKER_ELEC_PER_SEC(15),
    SPEAKER_WATER_PER_SEC(0),
    SPEAKER_SESSION(2),

    STOVE_ELEC_PER_SEC(100),
    STOVE_WATER_PER_SEC(0),
    STOVE_SESSION(2),

    TV_ELEC_PER_SEC(70),
    TV_WATER_PER_SEC(0),
    TV_SESSION(2);

    private final int value;
}
