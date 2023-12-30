package cvut.fel.omo.report;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.CreatureAPI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ActivityAndUsageReport {
    private static List<String> reportList;

    public static void generateReport(CreatureAPI creature) {
        //todo map traversal
//        for (ApplianceAPI appliance: creature.getUsedApplianceList()) {
//            reportList
//        }
    }

    public static void saveReport(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".log"))) {
            for (String report: reportList) {
                writer.write(report);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save report");
        }
    }
}
