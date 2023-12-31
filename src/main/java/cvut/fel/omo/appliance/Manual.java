package cvut.fel.omo.appliance;

import lombok.Getter;

@Getter
public class Manual {

    private final int timeReqToFix;

    public Manual(int timeReqToFix) {
        this.timeReqToFix = timeReqToFix;
    }

}
