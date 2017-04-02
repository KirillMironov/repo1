package expedia;

/**
 * Created by 123 on 26.11.2016.
 */
public class ReservationArchiver {
    public void archive(Reservation reservation) {
        reservation.storeIntoDatabase();
    }
}
