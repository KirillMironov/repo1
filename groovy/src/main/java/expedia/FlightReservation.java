package expedia;

import java.util.Date;

/**
 * Created by 123 on 26.11.2016.
 */
public class FlightReservation extends ActiveReservation {
    String type;
    Date departureDate;
    String from;
    String to;

    @Override
    public void storeIntoDatabase() {

    }
}


