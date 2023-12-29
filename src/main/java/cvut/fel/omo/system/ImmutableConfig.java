package cvut.fel.omo.system;

import cvut.fel.omo.creature.Creature;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public record ImmutableConfig(int simDuration, int floorNum, int roomNum, List<Creature> creatureList, List<String> roomList) {}
