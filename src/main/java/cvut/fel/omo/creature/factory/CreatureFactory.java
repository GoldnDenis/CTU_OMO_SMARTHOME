package cvut.fel.omo.creature.factory;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.visitors.*;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.system.Logging;

import java.util.Optional;
import java.util.logging.Level;

public class CreatureFactory {
    public Optional<Creature> createCreature(String type, String name) {
        Creature creature = null;

        switch (type) {
            case "Adult" -> creature = new Adult(name);
            case "Child" -> creature = new Child(name);
            case "Animal" -> creature = new Animal(name);
            default -> Logging.log(Level.WARNING, type + " is not a viable creature");
        }

        return Optional.ofNullable(creature);
    }
}
