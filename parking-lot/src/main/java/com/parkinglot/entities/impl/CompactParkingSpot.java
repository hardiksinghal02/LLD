package com.parkinglot.entities.impl;

import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.enums.SpotType;

public class CompactParkingSpot extends ParkingSpot {
    public CompactParkingSpot(String id, String levelId
//            , String parkingLotId
    ) {
        super(id, levelId,
//                parkingLotId,
                SpotType.COMPACT);
    }
}
