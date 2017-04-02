package expedia;

import java.util.Date;

/**
 * Created by 123 on 26.11.2016.
 */
public class HotelReservation extends ActiveReservation {
    private Date from;
    private Date to;
    private Hotel hotel;
    private int rooms;
    private int adults;
    private int children;

    public HotelReservation() {

    }

    public HotelReservation(Date from, Date to, Hotel hotel, int rooms, int adults, int children) {
        this.from = from;
        this.to = to;
        this.hotel = hotel;
        this.rooms = rooms;
        this.adults = adults;
        this.children = children;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public int getRooms() {
        return rooms;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public void cancelRooms(int number) {
        if(rooms == 1) {
            throw new IllegalStateException();
        }else {
            if(rooms - number < 1) {
                throw new IllegalStateException();
            }else {
                rooms = rooms - number;
            }
        }
    }

    @Override
    public void storeIntoDatabase() {

    }
}
