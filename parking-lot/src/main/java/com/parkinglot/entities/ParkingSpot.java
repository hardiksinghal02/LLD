package com.parkinglot.entities;

import com.lld.entity.AbstractEntity;
import com.parkinglot.enums.SpotType;
import com.parkinglot.factory.ParkingSpotFactory;
import lombok.Getter;

import java.util.Objects;

@Getter
public abstract class ParkingSpot extends AbstractEntity<ParkingSpot> {
    private String levelId;

    private SpotType spotType;

    private boolean available;

    public ParkingSpot(String id, String levelId, SpotType spotType, boolean available) {
        this.id = id;
        this.levelId = levelId;
        this.spotType = spotType;
        this.available = available;
    }

    public String toString() {
        return id + ", " + levelId + spotType;
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
