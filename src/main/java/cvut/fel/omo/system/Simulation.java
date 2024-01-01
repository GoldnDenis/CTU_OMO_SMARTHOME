package cvut.fel.omo.system;

import cvut.fel.omo.appliance.API.ApplianceAPI;
import cvut.fel.omo.appliance.state.Off;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.LocalEventListener;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.event.GlobalEventAccumulator;
import cvut.fel.omo.home.SmartHome;
import cvut.fel.omo.report.ReportHub;
import cvut.fel.omo.sensor.GlobalEventDetector;
import cvut.fel.omo.sensor.GlobalEventListener;

import java.util.List;
import java.util.Optional;

public class Simulation {
    private SmartHome home;
    private List<CreatureAPI> creatures;

    private GlobalEventDetector globalEventDetector;
    private ConfigReader config;

    private ReportHub reportHub;
    private GlobalEventAccumulator globalEventAccumulator;

    public Simulation() {
        this.config = new ConfigReader();
        this.reportHub = new ReportHub();
        this.globalEventAccumulator = new GlobalEventAccumulator();
        this.globalEventDetector = new GlobalEventDetector();
    }

    public void run(String configPath) {

        String configFile = getConfig(configPath);
        setUpSim();

        reportHub.generateHouseConfigurationReport(configFile, config.getConfig());

        setUpEventDetectors();

        for (int day = 1; day <= config.getDuration(); ++day) {
            System.out.println("(" + day + ")_Day_(" + day + ")");
            for (int hour = 0; hour < 24; ++hour) {
                System.out.println("<-> " + hour + ":00 <->");

                if (hour == 6) {
                    notifyGlobalEvent(GLOBAL_EVENT.SUN_HAS_RISEN_UP);
                }
                if (hour == 19) {
                    notifyGlobalEvent(GLOBAL_EVENT.NIGHT_FELL);
                }
                generateGlobalEvent().ifPresent(this::notifyGlobalEvent);

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

    private void setUpGlobalEventDetector() {
        getAppliances()
                .forEach(applianceAPI ->
                        globalEventDetector.attach(new GlobalEventListener(applianceAPI))
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
        setUpGlobalEventDetector();
        setUpLocalEventDetector();
    }

    private void notifyGlobalEvent(GLOBAL_EVENT event) {
        globalEventDetector.notifyAll(event);
        globalEventAccumulator.accumulateGlobalEvent(event);
    }

    private Optional<GLOBAL_EVENT> generateGlobalEvent() {
        if (RandomGenerator.hasHappened(90)) {
            return Optional.of(GLOBAL_EVENT.ELECTRICITY_SHUT_OFF);
        }
        if (RandomGenerator.hasHappened(90)) {
            return Optional.of(GLOBAL_EVENT.WATER_SHUT_OFF);
        }
        if (RandomGenerator.hasHappened(90)) {
            return Optional.of(GLOBAL_EVENT.NON_SATISFYING_TEMP);
        }
        return Optional.empty();
    }

}
