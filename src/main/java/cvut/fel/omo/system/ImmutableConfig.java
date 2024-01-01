package cvut.fel.omo.system;

import java.util.List;

public record ImmutableConfig(int simDuration, List<String> creatureList, List<String> roomList) {
}
