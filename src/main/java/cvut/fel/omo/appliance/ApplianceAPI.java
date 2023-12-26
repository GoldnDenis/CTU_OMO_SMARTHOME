package cvut.fel.omo.appliance;

import cvut.fel.omo.appliance.state.ApplianceState;
import cvut.fel.omo.appliance.state.Off;

public class ApplianceAPI {
    private final Appliance appliance;
    private ApplianceState state;

    public ApplianceAPI(Appliance appliance) {
        this.appliance = appliance;
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
}
