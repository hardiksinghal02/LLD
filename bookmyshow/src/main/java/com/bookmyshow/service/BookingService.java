package com.bookmyshow.service;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.entity.Seat;
import com.bookmyshow.response.BookingResponse;

import java.util.List;

public interface BookingService {

    List<Seat> getAllSeatsForShow(String showId);
    BookingResponse bookSeat(String usedId, String showId, String seatId);
    List<Booking> getBookingsForUser(String userId);
    BookingResponse cancelBooking(String bookingId);


}
