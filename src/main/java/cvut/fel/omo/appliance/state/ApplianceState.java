package cvut.fel.omo.appliance.state;

import cvut.fel.omo.appliance.ApplianceAPI;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ApplianceState{

    protected ApplianceAPI applianceAPI;

    abstract public void breakDown();

    abstract public void sleep();

    abstract public void turnOn();

    abstract public void turnOff();

    abstract public void fix();
}
