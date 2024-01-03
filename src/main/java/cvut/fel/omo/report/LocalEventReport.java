package cvut.fel.omo.report;

import cvut.fel.omo.appliance.API.ApplianceAPI;

import java.util.Map;

public class LocalEventReport extends AbstractReport {
    private int counter = 0;

    public LocalEventReport() {
        super();
        this.fileName = "LocalEventReport.log";
    }

    public void generateReport(ApplianceAPI applianceAPI) {
        reportList.add(++counter + ") '" + applianceAPI.getName() + "', id=" + applianceAPI.getId() + " :");
        for (Map.Entry<String, Integer> entry : applianceAPI.getBreakdownMap().entrySet()) {
            reportList.add(entry.getKey() + " broke this appliance " + entry.getValue() + " times");
        }
    }
}
