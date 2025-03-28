package com.parkinglot.service.impl;

import com.lld.exception.ErrorType;
import com.lld.utils.DateUtils;
import com.parkinglot.dao.BookingDao;
import com.parkinglot.entities.Booking;
import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.enums.BookingStatus;
import com.parkinglot.exception.ParkingLotException;
import com.parkinglot.request.EntryRequest;
import com.parkinglot.response.ParkingTicket;
import com.parkinglot.service.BookingService;
import com.parkinglot.service.ParkingLotService;

import java.util.Optional;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {

    private final ParkingLotService parkingLotService;
    private final BookingDao bookingDao;

    public BookingServiceImpl(ParkingLotService parkingLotService, BookingDao bookingDao) {
        this.parkingLotService = parkingLotService;
        this.bookingDao = bookingDao;
    }

    @Override
    public ParkingTicket entry(EntryRequest entryRequest) {
        Optional<ParkingSpot> parkingSpotOptional =
                parkingLotService.getAvailableSpots(
                                entryRequest.getParkingLotId(),
                                entryRequest.getVehicleType()
                        )
                        .stream()
                        .filter(ParkingSpot::isAvailable)
                        .findFirst();

        if (parkingSpotOptional.isEmpty()) {
            throw new ParkingLotException(ErrorType.NOT_FOUND,
                    String.format("No spot found for parkingLotId : %s, vehicleType : %s",
                            entryRequest.getParkingLotId(),
                            entryRequest.getVehicleType()));
        }

        Optional<Booking> savedBooking = bookingDao.save(
                Booking.builder()
                        .id(UUID.randomUUID().toString())
                        .numberPlate(entryRequest.getNumberPlate())
                        .spotId(parkingSpotOptional.get().getId())
                        .entryTime(System.currentTimeMillis())
                        .status(BookingStatus.SPOT_ON_HOLD)
                        .build()
        );

        if (savedBooking.isEmpty()) {
            throw new ParkingLotException(ErrorType.SOMETHING_WENT_WRONG,
                    String.format("Something went wrong while booking for parkingLotId : %s, vehicleType : %s",
                            entryRequest.getParkingLotId(),
                            entryRequest.getVehicleType()));
        }

        Booking booking = savedBooking.get();

        return ParkingTicket.builder()
                .bookingId(booking.getId())
                .numberPlate(booking.getNumberPlate())
                .entryTime(DateUtils.epochToString(booking.getEntryTime()))
                .build();
    }
}
