package com.parkinglot.service.impl;

import com.parkinglot.entities.Booking;
import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.enums.SpotType;
import com.parkinglot.exception.ErrorType;
import com.parkinglot.exception.ParkingLotException;
import com.parkinglot.service.BookingService;
import com.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.Optional;

public class BookingServiceImpl implements BookingService {

    private final ParkingLotService parkingLotService;

    public BookingServiceImpl(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public boolean checkAvailability(String vehicleType, String startTime, String endTime) {
        return false;
    }

    public Booking reserve(String vehicleType, String startTime, String endTime) {
        return null;
    }

    public ParkingSpot findParkingSpot(String parkingLotId, String vehicleType) {
//        parkingLevelDao.fin
        List<ParkingSpot> allParkingSpots = parkingLotService.findAllParkingSpotsForParkingLot(parkingLotId);

        if (allParkingSpots == null || allParkingSpots.isEmpty()) {
            throw new ParkingLotException(ErrorType.NOT_FOUND, "No parkinglot found for id : " + parkingLotId);
        }

        SpotType spotType = SpotType.fromName(vehicleType);

        Optional<ParkingSpot> parkingSpotOptional = allParkingSpots
                .stream()
                .filter(spot -> spot.getSpotType().equals(spotType))
                .findFirst();

        if(parkingSpotOptional.isEmpty()) {
            throw new ParkingLotException(ErrorType.NOT_FOUND, "No parking spot found for vehicle type : " + vehicleType);
        }

        return parkingSpotOptional.get();
    }
}
