package com.parkinglot.service;

import com.parkinglot.request.EntryRequest;
import com.parkinglot.response.ParkingTicket;

public interface BookingService {

    ParkingTicket entry(EntryRequest entryRequest);
}
