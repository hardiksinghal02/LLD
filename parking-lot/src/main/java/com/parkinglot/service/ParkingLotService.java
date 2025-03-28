package com.parkinglot.service;

import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.ParkingSpot;

import java.util.List;

public interface ParkingLotService {

    List<ParkingLot> findAllParkingLots();

    List<ParkingSpot> findAllParkingSpotsForParkingLot(String parkingLotId);

}
