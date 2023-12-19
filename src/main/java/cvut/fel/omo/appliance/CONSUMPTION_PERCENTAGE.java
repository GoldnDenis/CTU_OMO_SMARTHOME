package cvut.fel.omo.appliance;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CONSUMPTION_PERCENTAGE {
    FULL_CONSUMPTION(1),
    IDLE_CONSUMPTION(0.1),
    NO_CONSUMPTION(0);

    private final double percent;
}
