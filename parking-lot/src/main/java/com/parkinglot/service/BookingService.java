package com.parkinglot.service;

import com.parkinglot.entities.Booking;
import com.parkinglot.entities.ParkingSpot;

public interface BookingService {

    boolean checkAvailability(String vehicleType, String startTime, String endTime);

    Booking reserve(String vehicleType, String startTime, String endTime);

    ParkingSpot findParkingSpot(String parkingLotId, String vehicleType);
}
