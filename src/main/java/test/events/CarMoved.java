package test.events;

/**
 * Created by tosh on 2017-06-23.
 */
public class CarMoved {
    private final String licensePlateNumber;

    public CarMoved(String licensePlateNumber) {

        this.licensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
}
