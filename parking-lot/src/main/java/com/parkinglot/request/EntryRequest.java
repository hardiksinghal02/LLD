package com.parkinglot.request;

import lombok.Getter;

public record EntryRequest(String numberPlate, String vehicleType, String parkingLotId) { }
