package expedia;

/**
 * Created by 123 on 26.11.2016.
 */
public abstract class ActiveReservation implements Reservation{

    long id;

    public void prepareBooking() {
        /*User fills the form with credit card and personal data*/
    }

    public void completeBooking() {
        /*Expedia contacts Visa to verify credit card information and stores reservation in database*/
    }

    public void cancel() {

    }
}
