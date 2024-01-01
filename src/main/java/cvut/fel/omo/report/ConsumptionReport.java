package cvut.fel.omo.report;

import cvut.fel.omo.appliance.API.ApplianceAPI;

public class ConsumptionReport extends AbstractReport {
    private static int counter = 0;

    public ConsumptionReport() {
        super();
        this.fileName = "ConsumptionReport.log";
    }

    public void generateReport(ApplianceAPI appliance) {
        reportList.add(++counter + ") '" + appliance.getName() + "', id=" + appliance.getId() + " :");
        reportList.add("Water consumption = " + appliance.getConsumedWater() + ";");
        reportList.add("Electricity consumption = " + appliance.getConsumedElectricity() + ";");
    }
}
