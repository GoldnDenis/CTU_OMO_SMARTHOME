package cvut.fel.omo.report;

import cvut.fel.omo.creature.API.CreatureAPI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventReport {
    private static final List<String> reportList = new ArrayList<>();

    public static void generateReport() {

    }

    public static void saveReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("EventReport.log"))) {
            for (String report: reportList) {
                writer.write(report);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save report");
        }
    }
}
