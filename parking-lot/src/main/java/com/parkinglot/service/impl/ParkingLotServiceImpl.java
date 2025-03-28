package com.parkinglot.service.impl;

import com.parkinglot.dao.ParkingLevelDao;
import com.parkinglot.dao.ParkingLotDao;
import com.parkinglot.dao.ParkingSpotDao;
import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLevelDao parkingLevelDao;

    private final ParkingSpotDao parkingSpotDao;

    private final ParkingLotDao parkingLotDao;

    public ParkingLotServiceImpl(
            ParkingLevelDao parkingLevelDao,
            ParkingSpotDao parkingSpotDao,
            ParkingLotDao parkingLotDao) {
        this.parkingLevelDao = parkingLevelDao;
        this.parkingSpotDao = parkingSpotDao;
        this.parkingLotDao = parkingLotDao;
    }

    public List<ParkingLot> findAllParkingLots() {
        return parkingLotDao.fetchAll();
    }

    @Override
    public List<ParkingSpot> findAllParkingSpotsForParkingLot(String parkingLotId) {
        return parkingLevelDao.findAllParkingLevels(parkingLotId)
                .stream()
                .flatMap(parkingLevel -> parkingSpotDao.findByLevelId(parkingLevel.getId()).stream())
                .collect(Collectors.toList());
    }
}
