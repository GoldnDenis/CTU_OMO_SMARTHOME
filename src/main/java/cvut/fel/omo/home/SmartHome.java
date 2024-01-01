package cvut.fel.omo.home;

import cvut.fel.omo.home.builder.RoomBuilder;
import cvut.fel.omo.home.builder.RoomDirector;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

@AllArgsConstructor
@Getter
public class SmartHome {
    private List<Room> rooms;
    private RoomDirector director;

    public SmartHome() {
        this.rooms = new ArrayList<>();
        this.director = new RoomDirector();
    }

    public void addNewRoom(String name) {
        switch (name) {
            case "Kitchen" -> rooms.add(director.buildKitchen(new RoomBuilder()));
            case "Living Room" -> rooms.add(director.buildLivingRoom(new RoomBuilder()));
            case "Bedroom" -> rooms.add(director.buildBedroom(new RoomBuilder()));
            case "Office" -> rooms.add(director.buildOffice(new RoomBuilder()));
            case "Shower" -> rooms.add(director.Shower(new RoomBuilder()));
            default -> System.err.println(name + " is not a viable room");
        }
    }

    public int getRoomSize() {return rooms.size();}
}
