package expedia;

import org.junit.Test;

/**
 * Created by 123 on 26.11.2016.
 */
public class ExpediaTest {
    @Test
    public void test() {
        ReturnFlightReservation fr = new ReturnFlightReservation();
        fr.prepareBooking();

        HotelReservation hr = new HotelReservation();
        hr.prepareBooking();
    }
}


