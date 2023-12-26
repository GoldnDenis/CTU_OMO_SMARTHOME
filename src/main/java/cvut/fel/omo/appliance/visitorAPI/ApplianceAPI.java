package cvut.fel.omo.appliance.visitorAPI;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.state.ApplianceState;
import cvut.fel.omo.appliance.state.Off;

public abstract class ApplianceAPI {
    protected static int counter = 1;

    protected final Appliance appliance;
    protected ApplianceState state;

    public ApplianceAPI() {
        this.appliance = new Appliance();
        appliance.setId(counter++);
        this.state = new Off(this);
    }

    public void changeState(ApplianceState state) {
        this.state = state;
    }

    public void setConsumptionPercent(double percent) {
        appliance.setConsumptionPercent(percent);
    }

    public String toSting() {
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

    abstract void react();

}
