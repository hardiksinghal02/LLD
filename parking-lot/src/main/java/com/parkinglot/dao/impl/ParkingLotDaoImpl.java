package com.parkinglot.dao.impl;

import com.lld.dao.impl.AbstractDaoImpl;
import com.parkinglot.dao.ParkingLotDao;
import com.parkinglot.entities.ParkingLot;

public class ParkingLotDaoImpl extends AbstractDaoImpl<ParkingLot> implements ParkingLotDao {

    private static ParkingLotDaoImpl instance;

    public static ParkingLotDaoImpl getInstance() {
        if (instance == null) {
            instance = new ParkingLotDaoImpl();
        }
        return instance;
    }

    private ParkingLotDaoImpl() {
    }
}
