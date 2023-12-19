package cvut.fel.omo.home;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Floor {

    private int id;
    private List<Room> rooms;

}
