package com.parkinglot.factory;

import com.parkinglot.entities.ParkingLevel;
import com.parkinglot.entities.impl.RegularParkingLevel;

public class ParkingLevelFactory {

    public static ParkingLevel clone(ParkingLevel parkingLevel) {
        if(parkingLevel instanceof RegularParkingLevel) {
            return new RegularParkingLevel(parkingLevel.getId(),
                    parkingLevel.getParkingLotId(), parkingLevel.getDisplayBoard());
        }

        return null;
    }
}
