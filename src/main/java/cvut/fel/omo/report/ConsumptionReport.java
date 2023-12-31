package cvut.fel.omo.report;

import cvut.fel.omo.creature.API.CreatureAPI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ConsumptionReport {
    private static List<String> reportList;

    public static void generateReport() {
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
