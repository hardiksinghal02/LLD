package com.parkinglot.entities.impl;

import com.parkinglot.entities.DisplayBoard;
import com.parkinglot.entities.ParkingLevel;

public class RegularParkingLevel extends ParkingLevel {
    public RegularParkingLevel(String id, String parkingLotId, DisplayBoard displayBoard) {
        super(id, parkingLotId, displayBoard);
//        super.setDisplayBoard(new DisplayBoard(this));
    }
}
