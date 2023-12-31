package cvut.fel.omo.appliance.API;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.LocalEventDetector;
import cvut.fel.omo.appliance.state.Active;
import cvut.fel.omo.appliance.state.ApplianceState;
import cvut.fel.omo.appliance.state.Broken;
import cvut.fel.omo.appliance.state.Off;
import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.creature.LocalEventListener;
import cvut.fel.omo.event.GLOBAL_EVENT;
import cvut.fel.omo.system.RandomGenerator;
import lombok.Getter;

public abstract class ApplianceAPI implements ApplianceVisitor {
    protected static int counter = 1;

    protected final Appliance appliance;

    @Getter
    protected ApplianceState state;

    public ApplianceAPI() {
        this.appliance = new Appliance();
        appliance.setId(counter++);
        this.state = new Off(this);
    }

    @Override
    public void visitAdult(Adult adult) {

    }

    @Override
    public void visitChild(Child child) {

    }

    @Override
    public void visitAnimal(Animal animal) {

    }

    public String getName() {
        return appliance.getName();
    }

    @Override
    public int getRequiredTime() {
        return this.appliance.getRequiredTime();
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

    public boolean isAvailable() { return !isActive() || !isBroken();}

    protected void breakingDownChance(double chance) {
        if (RandomGenerator.hasHappened(chance)) {
            this.breakDown();
        }
    }

}
