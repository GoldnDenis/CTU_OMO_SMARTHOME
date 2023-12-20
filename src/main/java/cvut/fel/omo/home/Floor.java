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

    private RoomDirector director;
    private RoomBuilder builder;

    private int id;
    private List<Room> rooms;

    public Floor(int id) {
        this.id = id;
        this.rooms = new ArrayList<>();
        this.director = new RoomDirector();
    }

    //todo: change the builder logic
    public void addKitchen() {
        builder = new RoomBuilder();
        director.buildKitchen(builder);
        rooms.add(builder.build());
    }


}
