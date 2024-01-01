package cvut.fel.omo.report;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.event.GlobalEventAccumulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventReport extends AbstractReport {
    private static int counter = 0;

    public EventReport() {
        super();
        this.fileName = "EventReport.log";
    }

    public void generateLocalReport(ApplianceAPI applianceAPI) {
        reportList.add(++counter + ") " + applianceAPI.getName() + " '" + applianceAPI.getId() + "':");
        for (Map.Entry<String, Integer> entry : applianceAPI.getBreakdownMap().entrySet()) {
            reportList.add(entry.getKey() + " broke this appliance " + entry.getValue() + " times");
        }
    }

    public void generateGlobalReport(GlobalEventAccumulator accumulator) {
        reportList.add("\nGlobal events:");
        for (Map.Entry<GLOBAL_EVENT, Integer> entry : accumulator.getOccurrenceMap().entrySet()) {
            reportList.add(entry.getKey() + " happened " + entry.getValue() + " times");
        }
    }
}
