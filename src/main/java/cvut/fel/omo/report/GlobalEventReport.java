package cvut.fel.omo.report;

import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.event.GlobalEventAccumulator;

import java.util.Map;

public class GlobalEventReport extends AbstractReport {
    public GlobalEventReport() {
        super();
        this.fileName = "GlobalEventReport.log";
    }

    public void generateGlobalReport(GlobalEventAccumulator accumulator) {
        for (Map.Entry<GLOBAL_EVENT, Integer> entry : accumulator.getOccurrenceMap().entrySet()) {
            reportList.add(entry.getKey() + " happened " + entry.getValue() + " times");
        }
    }
}
