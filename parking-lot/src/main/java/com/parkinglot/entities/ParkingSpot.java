package com.parkinglot.entities;

import com.lld.entity.AbstractEntity;
import com.parkinglot.enums.SpotType;
import com.parkinglot.factory.ParkingSpotFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
public abstract class ParkingSpot extends AbstractEntity<ParkingSpot> {
    private String levelId;

    private SpotType spotType;

    @Setter
    private boolean available;
    private Double pricePerHour;

    public ParkingSpot(String id, String levelId, SpotType spotType, boolean available, Double pricePerHour) {
        super(id);
        this.levelId = levelId;
        this.spotType = spotType;
        this.available = available;
        this.pricePerHour = pricePerHour;
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
