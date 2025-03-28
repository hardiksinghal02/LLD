package com.parkinglot.service.impl;

import com.lld.exception.ErrorType;
import com.parkinglot.dao.ParkingLevelDao;
import com.parkinglot.dao.ParkingLotDao;
import com.parkinglot.dao.ParkingSpotDao;
import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.enums.SpotType;
import com.parkinglot.exception.ParkingLotException;
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

    private List<ParkingSpot> findAllParkingSpotsForParkingLot(String parkingLotId) {
        return parkingLevelDao.findAllParkingLevels(parkingLotId)
                .stream()
                .flatMap(parkingLevel -> parkingSpotDao.findByLevelId(parkingLevel.getId()).stream())
                .collect(Collectors.toList());
    }

    public List<ParkingSpot> getAvailableSpots(String parkingLotId, String vehicleType) throws ParkingLotException {
        List<ParkingSpot> allParkingSpots = findAllParkingSpotsForParkingLot(parkingLotId);

        if (allParkingSpots == null || allParkingSpots.isEmpty()) {
            throw new ParkingLotException(ErrorType.NOT_FOUND, "No parkinglot found for id : " + parkingLotId);
        }

        SpotType spotType = SpotType.fromName(vehicleType);

        return allParkingSpots
                .stream()
                .filter(spot -> spot.getSpotType().equals(spotType))
                .collect(Collectors.toList());
    }
}
