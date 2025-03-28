package com.parkinglot.entities;

import com.parkinglot.enums.BookingStatus;

public class Booking {
    String id;
    String userId;
    String parkingLotId;
    String levelId;
    String spotId;
    Long startTime;
    Long endTime;
    BookingStatus status;
}
