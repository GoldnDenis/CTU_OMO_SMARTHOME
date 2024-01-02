package cvut.fel.omo.system;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.state.Off;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.LocalEventListener;
import cvut.fel.omo.event.GlobalEventAccumulator;
import cvut.fel.omo.home.SmartHome;
import cvut.fel.omo.report.ReportHub;
import cvut.fel.omo.sensor.GlobalEventListener;
import cvut.fel.omo.sensor.Sensor;

import java.util.List;

public class Simulation {
    private SmartHome home;
    private List<CreatureAPI> creatures;

    private final Sensor sensor;
    private final ConfigReader config;

    private final ReportHub reportHub;
    private final GlobalEventAccumulator globalEventAccumulator;

    public Simulation() {
        this.config = new ConfigReader();
        this.reportHub = new ReportHub();
        this.globalEventAccumulator = new GlobalEventAccumulator();
        this.sensor = new Sensor();
    }

    /**
     * starts the simulation with a specified config file.
     * In case none is present or the path is incorrect - a preset will be loaded
     * @param configPath path to the configuration file
    */
    public void run(String configPath) {
        String configFile = getConfig(configPath);
        setUpSim();

        setUpEventDetectors();
        startSimulationLoop();

        processReportInfo(configFile);
    }

    private void startSimulationLoop() {
        for (int day = 1; day <= config.getDuration(); ++day) {
            System.out.println("(" + day + ")_Day_(" + day + ")");
            for (int hour = 0; hour < 24; ++hour) {
                System.out.println("<-> " + hour + ":00 <->");

                if (hour == 6) {
                    sensor.detectSunRise();
                }
                if (hour == 19) {
                    sensor.detectNightFall();
                }
                sensor.tryToDetectGlobalEvent();

                creatures.forEach(creatureAPI -> {
                    creatureAPI.move(home.getRooms());
                    creatureAPI.interact(home.getRooms());
                });

                getAppliances()
                        .stream()
                        .filter(applianceAPI -> !(applianceAPI.getState() instanceof Off))
                        .forEach(ApplianceAPI::updateConsumption);
            }
        }
    }

    private void processReportInfo(String configFile) {
        reportHub.generateHouseConfigurationReport(configFile, config.getConfig());
        creatures.forEach(reportHub::generateActivityAndUsageReport);
        getAppliances()
                .forEach(applianceAPI -> {
                    reportHub.generateLocalEventReport(applianceAPI);
                    reportHub.generateConsumptionReport(applianceAPI);
                });
        reportHub.generateGlobalEventReport(globalEventAccumulator);

        reportHub.saveAllReports();
    }

    private String getConfig(String configPath) {
        if (config.readJson(configPath)) {
            return configPath;
        }
        return "preset";
    }

    private void setUpSim() {
        this.creatures = config.setUpCreatures();
        this.home = config.setUpHome();
    }

    private List<ApplianceAPI> getAppliances() {
        return home.getRooms()
                .stream()
                .flatMap(room -> room.getAppliances().stream())
                .toList();
    }

    private void setUpSensor() {
        getAppliances()
                .forEach(applianceAPI ->
                        sensor.attach(new GlobalEventListener(applianceAPI))
                );
    }

    private void setUpLocalEventDetector() {
        getAppliances()
                .forEach(applianceAPI ->
                        creatures.stream()
                                .filter(creatureAPI -> creatureAPI instanceof Adult)
                                .forEach(creatureAPI -> applianceAPI.attach(new LocalEventListener(creatureAPI)))
                );
    }

    private void setUpEventDetectors() {
        setUpSensor();
        setUpLocalEventDetector();
    }

}
