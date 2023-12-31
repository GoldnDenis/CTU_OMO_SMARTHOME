package cvut.fel.omo.report;

public class ReportHub {
    public static void saveAllReports() {
        ActivityAndUsageReport.saveReport();
        ConsumptionReport.saveReport();
        EventReport.saveReport();
        HouseConfigurationReport.saveReport();
    }
}
