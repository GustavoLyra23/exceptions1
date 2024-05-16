package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNunber;
    private Date checkin;
    private Date checkout;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Reservation() {
    }

    public Reservation(Integer roomNunber, Date checkin, Date checkout) {
        this.roomNunber = roomNunber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public Integer getRoomNunber() {
        return roomNunber;
    }

    public void setRoomNunber(Integer roomNunber) {
        this.roomNunber = roomNunber;
    }

    public long duration() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;

    }

    @Override
    public String toString() {
        return "Room "
                + roomNunber
                + ",check-in"
                + sdf.format(checkin)
                + ",check-out"
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";

    }

}
