package com.parkinglot.entities.impl;

import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.enums.SpotType;

public class RegularParkingSpot extends ParkingSpot {
    public RegularParkingSpot(String id, String levelId
//            , String parkingLotId
    ) {
        super(id, levelId
//                , parkingLotId
                , SpotType.REGULAR);
    }
}
