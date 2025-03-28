package com.parkinglot.dao;

import com.lld.dao.AbstractDao;
import com.parkinglot.entities.ParkingLot;

import java.util.Optional;

public interface ParkingLotDao extends AbstractDao<ParkingLot> {

    Optional<ParkingLot> findById(String id);
}
