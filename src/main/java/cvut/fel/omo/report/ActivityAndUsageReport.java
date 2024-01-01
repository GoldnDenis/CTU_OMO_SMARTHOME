package cvut.fel.omo.report;

import cvut.fel.omo.creature.API.CreatureAPI;

import java.util.Map;

public class ActivityAndUsageReport extends AbstractReport {
    private int counter = 0;

    public ActivityAndUsageReport() {
        super();
        this.fileName = "ActivityAndUsageReport.log";
    }

    public void generateReport(CreatureAPI creature) {
        reportList.add(++counter + ") " + creature.getType() + " '" + creature.getName() + "':");
        for (Map.Entry<String, Integer> entry : creature.getUsageMap().entrySet()) {
            reportList.add(entry.getKey() + " was used " + entry.getValue() + " times");
        }
    }
}
