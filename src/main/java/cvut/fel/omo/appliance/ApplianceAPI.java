package cvut.fel.omo.appliance;

import cvut.fel.omo.appliance.state.ApplianceState;

public class ApplianceAPI {

    private Appliance appliance;
    private ApplianceState state;

    public void changeState(ApplianceState state) {
        this.state = state;
    }

    public void setConsumptionPercent(double percent) {
        appliance.setConsumptionPercent(percent);
    }

    public String toSting() {
        return appliance.toString();
    }
}
