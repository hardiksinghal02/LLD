package com.parkinglot.service;

import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.ParkingSpot;

import java.util.List;
import java.util.Optional;

public interface ParkingLotService {

    List<ParkingSpot> getAvailableSpots(String parkingLotId, String vehicleType);

}
