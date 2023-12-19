package cvut.fel.omo.creature.factory;

import cvut.fel.omo.appliance.Appliance;
import cvut.fel.omo.appliance.visitors.*;
import cvut.fel.omo.creature.Adult;
import cvut.fel.omo.creature.Animal;
import cvut.fel.omo.creature.Child;
import cvut.fel.omo.creature.Creature;

import java.util.Optional;

public class CreatureFactory {
    public Optional<Creature> createCreature(String type, String name) {
        Creature creature = null;

        switch (type) {
            case "Adult" -> creature = new Adult(name);
            case "Child" -> creature = new Child(name);
            case "Animal" -> creature = new Animal(name);
            default -> {
                // log that the creature type is not viable
            }
        }

        return Optional.ofNullable(creature);
    }
}
