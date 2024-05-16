package model.entities;

import exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNunber;
    private Date checkin;
    private Date checkout;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    public Reservation() {
    }

    public Reservation(Integer roomNunber, Date checkin, Date checkout) throws DomainException {
        if (!checkout.after(checkin)) {
            throw new DomainException("Error in reservation: Checkout date must be after check-in date");
        }
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

    public void updateDates(Date checkIn, Date checkOut) throws DomainException {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.after(now)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Error in reservation: Checkout date must be after check-in date");

        }
        this.checkin = checkIn;
        this.checkout = checkOut;
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
