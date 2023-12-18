package cvut.fel.omo.appliance;

public class ApplianceAPI {
    public void interact() {
        switch ( CreatureType ) {
            case Adult:
                doThis;
                break;
            case Child:
                childStrategy();
                break;
            case Animal:
                break;
        }
    }
}
