package com.parkinglot.entities;

import com.lld.entity.AbstractEntity;
import com.parkinglot.factory.ParkingLotFactory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingLot extends AbstractEntity<ParkingLot> {
    private String name;
    private String address;

    public ParkingLot(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public ParkingLot clone() {
        return ParkingLotFactory.clone(this);
    }
}
