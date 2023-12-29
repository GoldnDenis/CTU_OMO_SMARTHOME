package cvut.fel.omo.creature.API;

import cvut.fel.omo.appliance.API.ApplianceVisitor;
import cvut.fel.omo.creature.API.CreatureAPI;

public class Adult extends CreatureAPI {

    public Adult(String name) {
        super(name);
    }

    @Override
    public void accept(ApplianceVisitor visitor) {
        visitor.visitAdult(this);
    }
}
