package cvut.fel.omo.creature.factory;

import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.creature.API.CreatureAPI;
import cvut.fel.omo.creature.Creature;
import cvut.fel.omo.system.Logging;

import java.util.Optional;
import java.util.logging.Level;

public class CreatureFactory {
    public Optional<CreatureAPI> createCreature(String type, String name) {
        CreatureAPI creature = null;

        switch (type) {
            case "Adult" -> creature = new Adult(name, type);
            case "Child" -> creature = new Child(name, type);
            case "Animal" -> creature = new Animal(name, type);
            default -> Logging.log(Level.WARNING, type + " is not a viable creature");
        }

        return Optional.ofNullable(creature);
    }
}
