package com.parkinglot.entities.impl;

import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.enums.SpotType;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(String id, String levelId, boolean available) {
        super(id, levelId, SpotType.LARGE, available, 20.0);
    }
}
