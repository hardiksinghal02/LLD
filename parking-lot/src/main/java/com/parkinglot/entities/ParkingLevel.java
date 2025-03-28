package com.parkinglot.entities;

import com.lld.entity.AbstractEntity;
import com.parkinglot.factory.ParkingLevelFactory;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class ParkingLevel extends AbstractEntity<ParkingLevel> {

    private String parkingLotId;

    private DisplayBoard displayBoard;

    public ParkingLevel(String id, String parkingLotId, DisplayBoard displayBoard) {
        this.id = id;
        this.parkingLotId = parkingLotId;
        this.displayBoard = displayBoard;
    }

    @Override
    public ParkingLevel clone() {
        return ParkingLevelFactory.clone(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(o == null || o.getClass() != getClass()) return false;

        ParkingLevel that = (ParkingLevel) o;
        return Objects.equals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
