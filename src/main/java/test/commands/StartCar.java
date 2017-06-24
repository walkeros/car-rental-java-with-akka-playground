package test.commands;

/**
 * Created by tosh on 2017-06-23.
 */
public class StartCar {

    private final String LicensePlateNumber;

    public StartCar(String licensePlateNumber) {
        LicensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() {
        return LicensePlateNumber;
    }
}
