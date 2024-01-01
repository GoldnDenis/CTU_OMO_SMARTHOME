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

    public void run(String configPath) {
        ConfigReader config = new ConfigReader();
        ReportHub reportHub = new ReportHub();

        String configFile = "preset";
        if (config.readJson(configPath)) {
            configFile = configPath;
        }
        List<CreatureAPI> creatures = config.setUpCreatures();
        SmartHome home = config.setUpHome();

        reportHub.generateHouseConfigurationReport(configFile, config.getConfig());

        GlobalEventAccumulator globalEventAccumulator = new GlobalEventAccumulator();
        GlobalEventDetector globalEventDetector = new GlobalEventDetector();
        home.getRooms()
                .stream()
                .flatMap(room -> room.getAppliances().stream())
                .forEach(applianceAPI ->
                        globalEventDetector.attach(new GlobalEventListener(applianceAPI))
                );

        home.getRooms()
                .stream()
                .flatMap(room -> room.getAppliances().stream())
                .forEach(applianceAPI ->
                        creatures.stream()
                                .filter(creatureAPI -> creatureAPI instanceof Adult)
                                .forEach(creatureAPI -> applianceAPI.attach(new LocalEventListener(creatureAPI)))
                );

        for (int day = 1; day <= config.getDuration(); ++day) {
            System.out.println("Day " + day + ")");
            for (int hour = 0; hour < 24; ++hour) {
                System.out.println("<-> " + hour + ":00 <->");

                if (hour == 6) {
                    globalEventDetector.notifyAll(GLOBAL_EVENT.SUN_HAS_RISEN_UP);
                    globalEventAccumulator.accumulateGlobalEvent(GLOBAL_EVENT.SUN_HAS_RISEN_UP);
                }

                if (hour == 19) {
                    globalEventDetector.notifyAll(GLOBAL_EVENT.NIGHT_FELL);
                    globalEventAccumulator.accumulateGlobalEvent(GLOBAL_EVENT.NIGHT_FELL);
                }

                generateGlobalEvent().ifPresent(
                        globalEvent -> {
                            globalEventAccumulator.accumulateGlobalEvent(globalEvent);
                            globalEventDetector.notifyAll(globalEvent);
                        }

                );

                creatures.forEach(creatureAPI -> {
                    creatureAPI.move(home.getRooms());
                    creatureAPI.interact(home.getRooms());
                });

                home.getRooms().stream()
                        .flatMap(room -> room.getAppliances().stream())
                        .filter(applianceAPI -> !(applianceAPI.getState() instanceof Off))
                        .forEach(ApplianceAPI::updateConsumption);
            }
        }

        creatures.forEach(reportHub::generateActivityAndUsageReport);
        home.getRooms().stream()
                .flatMap(room -> room.getAppliances().stream())
                .forEach(applianceAPI -> {
                    reportHub.generateLocalEventReport(applianceAPI);
                    reportHub.generateConsumptionReport(applianceAPI);
                });
        reportHub.generateGlobalEventReport(globalEventAccumulator);

        reportHub.saveAllReports();
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
