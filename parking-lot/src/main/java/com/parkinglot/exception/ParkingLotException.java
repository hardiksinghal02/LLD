package com.parkinglot.exception;

import com.lld.exception.ErrorType;

public class ParkingLotException extends RuntimeException {
    ErrorType errorType;

    public ParkingLotException(ErrorType errorType, String errorMessage) {
        errorType.setMessage(errorMessage);
        this.errorType = errorType;
    }

    public ParkingLotException(ErrorType errorType) {
        this.errorType = errorType;
    }
}
