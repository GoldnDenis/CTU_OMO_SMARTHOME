package cvut.fel.omo.creature.factory;

import cvut.fel.omo.creature.API.Adult;
import cvut.fel.omo.creature.API.Animal;
import cvut.fel.omo.creature.API.Child;
import cvut.fel.omo.creature.API.CreatureAPI;

import java.util.Optional;

public class CreatureFactory {
    public Optional<CreatureAPI> createCreature(String type, String name) {
        CreatureAPI creature = null;

        switch (type) {
            case "Adult" -> creature = new Adult(name);
            case "Child" -> creature = new Child(name);
            case "Animal" -> creature = new Animal(name);
            default -> System.err.println(type + " is not a viable creature");
        }

        return Optional.ofNullable(creature);
    }
}
