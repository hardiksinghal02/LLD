package com.parkinglot.request;

import lombok.Getter;

@Getter
public class EntryRequest {
    private String numberPlate;
    private String vehicleType;
    private String parkingLotId;

    public EntryRequest(String numberPlate, String vehicleType, String parkingLotId) {
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        this.parkingLotId = parkingLotId;
    }
}
