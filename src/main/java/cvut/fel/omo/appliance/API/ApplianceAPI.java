package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.LocalEventDetector;
import cvut.fel.omo.appliance.state.Active;
import cvut.fel.omo.appliance.state.ApplianceState;
import cvut.fel.omo.appliance.state.Broken;
import cvut.fel.omo.appliance.state.Off;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.LocalEventListener;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.utils.RandomGenerator;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class ApplianceAPI implements ApplianceVisitor {
    protected static int counter = 0;
    protected final Appliance appliance;

    protected LocalEventDetector localEventDetector;

    @Getter
    protected ApplianceState state;

    public ApplianceAPI() {
        this.appliance = new Appliance();
        appliance.setId(++counter);
        appliance.setBreakDownMap(new HashMap<>());
        this.state = new Off(this);
        this.localEventDetector = new LocalEventDetector();
    }

    public void updateConsumption() {
        appliance.updateConsumption();
    }

    public double getConsumedElectricity() {
        return appliance.getConsumedElectricity();
    }

    public double getConsumedWater() {
        return appliance.getConsumedWater();
    }

    public String getName() {
        return appliance.getName();
    }

    public int getId() {
        return appliance.getId();
    }

    public int getRequiredTime() {
        return appliance.getRequiredTime();
    }

    public void changeState(ApplianceState state) {
        this.state = state;
    }

    public void setConsumptionPercent(double percent) {
        appliance.setConsumptionPercent(percent);
    }

    public String toString() {
        return appliance.toString();
    }

    public void breakDown() {
        this.state.breakDown();
    }

    public void sleep() {
        this.state.sleep();
    }

    public void turnOn() {
        this.state.turnOn();
    }

    public void turnOff() {
        this.state.turnOff();
    }

    public void fix() {
        this.state.fix();
    }

    public abstract void react(GLOBAL_EVENT event);

    public boolean isBroken() {
        return this.state instanceof Broken;
    }

    public boolean isActive() {
        return this.state instanceof Active;
    }

    public boolean canFixBroken(CreatureAPI creature) {
        return isBroken() && creature.getType().equals("Adult");
    }

    protected void breakingDownChance(double chance, CreatureAPI creatureAPI) {
        if (RandomGenerator.hasHappened(chance)) {
            appliance.putBreakDownMap(creatureAPI.getName());
            this.breakDown();
        }
    }

    public int getTimeReqToFix() {
        return appliance.getTimeReqToFix();
    }

    public void attach(LocalEventListener listener) {
        localEventDetector.attach(listener);
    }

    public void notifyFirstNotBusy() {
        localEventDetector.notifyFirstNotBusy(this);
    }

    public Map<String, Integer> getBreakdownMap() {
        return appliance.getBreakDownMap();
    }

}
