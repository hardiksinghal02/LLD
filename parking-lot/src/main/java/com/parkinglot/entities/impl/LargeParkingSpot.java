package com.parkinglot.entities.impl;

import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.enums.SpotType;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(String id, String levelId
//            , String parkingLotId
    ) {
        super(id, levelId
//                , parkingLotId
                , SpotType.LARGE);
    }
}
