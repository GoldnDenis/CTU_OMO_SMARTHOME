package cvut.fel.omo.report;

import cvut.fel.omo.creature.API.CreatureAPI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActivityAndUsageReport {
    private static final List<String> reportList = new ArrayList<>();

    private static int counter = 0;

    public static void generateReport(CreatureAPI creature) {
        reportList.add(++counter + ") " + creature.getType() + " '" + creature.getName() + "':");
        for (Map.Entry<String, Integer> entry: creature.getUsageMap().entrySet()) {
            reportList.add(entry.getKey() + " was used " + entry.getValue() + " times");
        }
    }

    public static void saveReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ActivityAndUsageReport.log"))) {
            for (String report: reportList) {
                writer.write(report);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save report");
        }
    }
}
