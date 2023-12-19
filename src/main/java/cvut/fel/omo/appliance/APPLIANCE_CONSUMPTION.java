package cvut.fel.omo.appliance;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum APPLIANCE_CONSUMPTION {
    COMPUTER_ELEC_PER_SEC(210),
    COMPUTER_WATER_PER_SEC(0),

    DRINKMAKER_ELEC_PER_SEC(50),
    DRINKMAKER_WATER_PER_SEC(11),

    FOODDISP_ELEC_PER_SEC(20),
    FOODDISP_WATER_PER_SEC(5),

    FRIDGE_ELEC_PER_SEC(100),
    FRIDGE_WATER_PER_SEC(5),

    SPEAKER_ELEC_PER_SEC(15),
    SPEAKER_WATER_PER_SEC(0),

    STOVE_ELEC_PER_SEC(100),
    STOVE_WATER_PER_SEC(0),

    TV_ELEC_PER_SEC(70),
    TV_WATER_PER_SEC(0);

    private final int value;
}
