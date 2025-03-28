package com.parkinglot.entities;

import com.lld.entity.AbstractEntity;
import com.parkinglot.enums.SpotType;
import com.parkinglot.factory.ParkingSpotFactory;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class ParkingSpot extends AbstractEntity<ParkingSpot> {
    private String levelId;

//    private String parkingLotId;

    private SpotType spotType;

    public ParkingSpot(String id,
            String levelId,
//                       String parkingLotId,
                       SpotType spotType) {
        this.id = id;
        this.levelId = levelId;
//        this.parkingLotId = parkingLotId;
        this.spotType = spotType;
    }

    public String toString() {
        return id + ", " + levelId +
//                ", " + parkingLotId + ", " +
                spotType;
    }

    public ParkingSpot clone() {
        return ParkingSpotFactory.clone(this);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || o.getClass() != getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return Objects.equals(that.getId(), id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
