package cvut.fel.omo.event;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class GlobalEventAccumulator {

    @Getter
    Map<GLOBAL_EVENT, Integer> occurrenceMap;

    public GlobalEventAccumulator() {
        this.occurrenceMap = new HashMap<>();
    }

    public void accumulateGlobalEvent(GLOBAL_EVENT event) {
        if (occurrenceMap.containsKey(event) ) {
            int count = occurrenceMap.get(event);
            occurrenceMap.put(event, ++count);
        } else {
            occurrenceMap.put(event, 1);
        }
    }

}
