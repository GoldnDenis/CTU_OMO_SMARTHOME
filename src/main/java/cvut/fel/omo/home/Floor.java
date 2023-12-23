package cvut.fel.omo.home;

import cvut.fel.omo.home.builder.RoomBuilder;
import cvut.fel.omo.home.builder.RoomDirector;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Floor {

    private int id;
    private List<Room> rooms;

    private RoomDirector director;

    public Floor(int id) {
        this.id = id;
        this.rooms = new ArrayList<>();
        this.director = new RoomDirector();
    }

    //todo: change the builder logic
    private void addKitchen() {
        rooms.add(
                director.buildKitchen(new RoomBuilder())
        );
    }


}
