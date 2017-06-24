package playground.commands;

/**
 * Created by tosh on 2017-06-23.
 */
public class Move {

    private final String LicensePlateNumber;

    public Move(String licensePlateNumber) {
        LicensePlateNumber = licensePlateNumber;
    }

    public String getLicensePlateNumber() {
        return LicensePlateNumber;
    }
}
