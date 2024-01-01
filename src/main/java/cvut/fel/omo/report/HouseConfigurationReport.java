package cvut.fel.omo.report;

import cvut.fel.omo.system.ImmutableConfig;

public class HouseConfigurationReport extends AbstractReport {
    public HouseConfigurationReport() {
        super();
        this.fileName = "HouseConfigurationReport.log";
    }

    public void generateReport(String configName, ImmutableConfig config) {
        if (configName.equals("preset")) {
            reportList.add("A viable configuration file hasn't been loaded. " +
                    "SmartHome was launched from a standard preset:");
        } else {
            reportList.add("SmartHome was launched from '" + configName + "':");
        }

        reportList.add("{");
        reportList.add("\tDuration of the simulation = " + config.simDuration() + ";");
        reportList.add("\tCreatures = " + config.creatureList() + ";");
        reportList.add("\tRooms = " + config.roomList() + ";");
        reportList.add("}");
    }
}
