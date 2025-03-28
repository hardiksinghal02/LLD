package com.parkinglot.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ParkingTicket {
    private String bookingId;
    private String numberPlate;
    private String entryTime;
}
