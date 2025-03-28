package com.parkinglot.dao;

import com.lld.dao.AbstractDao;
import com.parkinglot.entities.ParkingLevel;

import java.util.List;

public interface ParkingLevelDao extends AbstractDao<ParkingLevel> {

    List<ParkingLevel> findAllParkingLevels(String parkingLotId);
}
