package com.parkinglot.service;

import com.parkinglot.request.EntryRequest;
import com.parkinglot.response.ParkingTicket;
import com.parkinglot.response.Receipt;

public interface BookingService {

    ParkingTicket entry(EntryRequest entryRequest);

    Receipt exit(ParkingTicket parkingTicket);
}
