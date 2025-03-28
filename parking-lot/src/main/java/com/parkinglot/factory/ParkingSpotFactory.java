package com.parkinglot.factory;

import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.entities.impl.CompactParkingSpot;
import com.parkinglot.entities.impl.LargeParkingSpot;
import com.parkinglot.entities.impl.RegularParkingSpot;

public class ParkingSpotFactory {

    public static ParkingSpot clone(ParkingSpot parkingSpot) {
        ParkingSpot cloned = null;

        if (parkingSpot instanceof CompactParkingSpot) {
            cloned = new CompactParkingSpot(parkingSpot.getId(), parkingSpot.getLevelId());
        } else if (parkingSpot instanceof LargeParkingSpot) {
            cloned = new LargeParkingSpot(parkingSpot.getId(), parkingSpot.getLevelId());
        } else if (parkingSpot instanceof RegularParkingSpot) {
            cloned = new RegularParkingSpot(parkingSpot.getId(), parkingSpot.getLevelId());
        }

        return cloned;
    }
}
