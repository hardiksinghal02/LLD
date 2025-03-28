package com.parkinglot.factory;

import com.parkinglot.entities.ParkingLot;
import com.parkinglot.entities.impl.RegularParkingLot;

public class ParkingLotFactory {

    public static ParkingLot clone(ParkingLot parkingLot) {
        if(parkingLot instanceof RegularParkingLot) {
            return new RegularParkingLot(parkingLot.getId(), parkingLot.getName(), parkingLot.getAddress());
        }

        System.out.println("Couldn't find concrete class for object of class : " + parkingLot.getClass());
        return null;
    }
}
