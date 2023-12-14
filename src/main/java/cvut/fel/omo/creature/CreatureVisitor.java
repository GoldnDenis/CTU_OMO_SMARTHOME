package cvut.fel.omo.creature;

import cvut.fel.omo.home.Room;

public interface CreatureVisitor {

    void visitRoom(Room room);

}
