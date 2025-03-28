package com.parkinglot.dao;

import com.lld.dao.AbstractDao;
import com.parkinglot.entities.ParkingSpot;

import java.util.List;

public interface ParkingSpotDao extends AbstractDao<ParkingSpot> {

    List<ParkingSpot> findByLevelId(String levelId);
}
