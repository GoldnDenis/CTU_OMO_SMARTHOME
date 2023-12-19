package cvut.fel.omo.appliance.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum STATE_CONSUMP_PERCENTAGE {
    FULL_CONSUMPTION(1),
    IDLE_CONSUMPTION(0.1),
    NO_CONSUMPTION(0);

    private final double percent;
}
