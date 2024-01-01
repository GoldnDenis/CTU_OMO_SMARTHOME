package cvut.fel.omo.report;

import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.system.ImmutableConfig;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HouseConfigurationReport {
    private static final List<String> reportList = new ArrayList<>();

    public static void generateReport(String configName) {
        if ( configName.equals("preset") ) {
            reportList.add("A viable configuration file hasn't been loaded." +
                    "SmartHome was launched from a standard preset:");
        } else {
            reportList.add("SmartHome was launched from '" + configName + "':");
        }
    }

    //todo
    public static void generateReport(ImmutableConfig config) {
        reportList.add("{");
        reportList.add("\tDuration of the simulation = " + config.simDuration() + ";");
        reportList.add("\tCreatures = " + config.creatureList() + ";");
        reportList.add("\tRooms = " + config.roomList() + ";");
        reportList.add("}");
    }

    public static void saveReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("HouseConfigurationReport.log"))) {
            for (String report: reportList) {
                writer.write(report);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save report");
        }
    }
}
