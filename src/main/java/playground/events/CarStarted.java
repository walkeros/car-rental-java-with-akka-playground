package playground.events;

/**
 * Created by tosh on 2017-06-23.
 */
public class CarStarted {
    private final String licensePlateNumber;

    public CarStarted(String licensePlateNumber) {

        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
}
