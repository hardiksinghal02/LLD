package com.parkinglot.service;

import com.parkinglot.constants.TestConstants;
import com.parkinglot.dao.impl.BookingDaoImpl;
import com.parkinglot.entities.Booking;
import com.parkinglot.entities.impl.CompactParkingSpot;
import com.parkinglot.enums.BookingStatus;
import com.parkinglot.request.EntryRequest;
import com.parkinglot.response.ParkingTicket;
import com.parkinglot.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
    @Mock
    private ParkingLotService parkingLotService;
    @Mock
    private BookingDaoImpl bookingDao;
    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    public void entryTest() {
        when(parkingLotService.getAvailableSpots(
                TestConstants.EXISTING_PARKING_LOT_ID,
                TestConstants.COMPACT_VEHICLE_TYPE))
                .thenReturn(
                        List.of(
                                new CompactParkingSpot(
                                        TestConstants.PARKING_SPOT_ID,
                                        TestConstants.PARKING_LEVEL_1,
                                        true
                                )
                        )
                );

        when(bookingDao.save(any())).thenReturn(
                Optional.of(
                        Booking.builder()
                                .id(TestConstants.BOOKING_ID)
                                .numberPlate(TestConstants.NUMBER_PLATE)
                                .spotId(TestConstants.PARKING_SPOT_ID)
                                .status(BookingStatus.SPOT_ON_HOLD)
                                .entryTime(System.currentTimeMillis())
                                .build()
                )
        );

        ParkingTicket ticket = bookingService.entry(
                new EntryRequest(
                        TestConstants.NUMBER_PLATE,
                        TestConstants.COMPACT_VEHICLE_TYPE,
                        TestConstants.EXISTING_PARKING_LOT_ID)
        );

        assertEquals(ticket.getNumberPlate(), TestConstants.NUMBER_PLATE);
    }
}
