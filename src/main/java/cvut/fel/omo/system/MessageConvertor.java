package cvut.fel.omo.system;

public class MessageConvertor {

    public static String isBrokenMsg(String appliance) {
        return appliance + " : is broken";
    }

    public static String idleMsg(String appliance) {
        return appliance + " : in idle mode";
    }

    public static String turnOnMsg(String appliance) {
        return appliance + " : turned on";
    }

    public static String turnOffMsg(String appliance) {
        return appliance + " : turned off";
    }

    public static String fixMsg(String appliance) {
        return appliance + " : is fixed";
    }
}
