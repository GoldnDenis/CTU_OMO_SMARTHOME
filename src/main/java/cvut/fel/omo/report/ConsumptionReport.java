package cvut.fel.omo.report;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.CreatureAPI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsumptionReport {
    private static final List<String> reportList = new ArrayList<>();

    private static int counter = 0;

    public static void generateReport(ApplianceAPI appliance) {
        reportList.add(++counter + ") '" + appliance.getName() + "', id=" + appliance.getId() + " :");
        reportList.add("Water consumption = " + appliance.getConsumedWater() + ";");
        reportList.add("Electricity consumption = " + appliance.getConsumedElectricity() + ";");
    }

    public static void saveReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "ConsumptionReport.log"))) {
            for (String report: reportList) {
                writer.write(report);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save report");
        }
    }
}
