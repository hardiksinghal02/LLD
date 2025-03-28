package com.parkinglot.exception;

public class ParkingLotException extends RuntimeException {
    ErrorType errorType;

    public ParkingLotException(ErrorType errorType, String errorMessage) {
        errorType.setMessage(errorMessage);
        this.errorType = errorType;
    }
}
