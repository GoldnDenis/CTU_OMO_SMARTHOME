package cvut.fel.omo.report;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.event.GlobalEventAccumulator;
import cvut.fel.omo.system.ImmutableConfig;

public class ReportHub {
    private final ActivityAndUsageReport activityAndUsageReport;
    private final ConsumptionReport consumptionReport;
    private final LocalEventReport localEventReport;
    private final GlobalEventReport globalEventReport;
    private final HouseConfigurationReport houseConfigurationReport;

    public ReportHub() {
        activityAndUsageReport = new ActivityAndUsageReport();
        consumptionReport = new ConsumptionReport();
        localEventReport = new LocalEventReport();
        globalEventReport = new GlobalEventReport();
        houseConfigurationReport = new HouseConfigurationReport();
    }

    public void generateActivityAndUsageReport(CreatureAPI creatureAPI) {
        activityAndUsageReport.generateReport(creatureAPI);
    }

    public void generateConsumptionReport(ApplianceAPI applianceAPI) {
        consumptionReport.generateReport(applianceAPI);
    }

    public void generateLocalEventReport(ApplianceAPI applianceAPI) {
        localEventReport.generateLocalReport(applianceAPI);
    }

    public void generateGlobalEventReport(GlobalEventAccumulator accumulator) {
        globalEventReport.generateGlobalReport(accumulator);
    }

    public void generateHouseConfigurationReport(String configFile, ImmutableConfig config) {
        houseConfigurationReport.generateReport(configFile, config);
    }

    public void saveAllReports() {
        activityAndUsageReport.saveReport();
        consumptionReport.saveReport();
        localEventReport.saveReport();
        globalEventReport.saveReport();
        houseConfigurationReport.saveReport();
    }
}
