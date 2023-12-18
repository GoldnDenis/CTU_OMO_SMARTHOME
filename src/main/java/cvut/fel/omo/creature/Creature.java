package cvut.fel.omo.creature;

import cvut.fel.omo.appliance.visitors.ApplianceVisitor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Creature {

    private int id;
    private String name;

    public abstract void accept(ApplianceVisitor visitor);

}
