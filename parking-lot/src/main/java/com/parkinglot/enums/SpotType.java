package com.parkinglot.enums;

import com.lld.exception.ErrorType;
import com.parkinglot.exception.ParkingLotException;

public enum SpotType {
    REGULAR,
    LARGE,
    COMPACT;

    public static SpotType fromName(String name) {
        try {
            return SpotType.valueOf(name.toUpperCase());
        } catch (Exception e) {
            throw new ParkingLotException(ErrorType.NOT_FOUND, "Invalid spot type : " + name);
        }
    }
}
