package com.parkinglot.service;

import com.parkinglot.constants.TestConstants;
import com.parkinglot.entities.ParkingSpot;
import com.parkinglot.entities.impl.CompactParkingSpot;
import com.parkinglot.entities.impl.RegularParkingSpot;
import com.parkinglot.exception.ParkingLotException;
import com.parkinglot.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {
    @Mock
    private ParkingLotService parkingLotService;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void getParkingSpotForVehicle() {
        String parkingLotId = TestConstants.EXISTING_PARKING_LOT_ID;
        String vehicleType = TestConstants.COMPACT_VEHICLE_TYPE;

        when(parkingLotService.findAllParkingSpotsForParkingLot(TestConstants.EXISTING_PARKING_LOT_ID))
                .thenReturn(
                        List.of(
                                new CompactParkingSpot(
                                        TestConstants.PARKING_SPOT_ID,
                                        TestConstants.PARKING_LEVEL_1)
                        )
                );

        ParkingSpot parkingSpot = bookingService.findParkingSpot(parkingLotId, vehicleType);
        assertEquals(TestConstants.PARKING_LEVEL_1, parkingSpot.getLevelId());
    }

    @Test
    void getParkingSpotForVehicleSpotsNull() {
        String parkingLotId = TestConstants.MISSING_PARKING_LOT_ID;
        String vehicleType = TestConstants.COMPACT_VEHICLE_TYPE;

        when(parkingLotService.findAllParkingSpotsForParkingLot(TestConstants.MISSING_PARKING_LOT_ID))
                .thenReturn(null);

        assertThrows(ParkingLotException.class, () -> {
            bookingService.findParkingSpot(parkingLotId, vehicleType);
        });
    }

    @Test
    void getParkingSpotForVehicleSpotsEmpty() {
        String parkingLotId = TestConstants.MISSING_PARKING_LOT_ID;
        String vehicleType = TestConstants.COMPACT_VEHICLE_TYPE;

        when(parkingLotService.findAllParkingSpotsForParkingLot(TestConstants.MISSING_PARKING_LOT_ID))
                .thenReturn(Collections.emptyList());

        assertThrows(ParkingLotException.class, () -> bookingService.findParkingSpot(parkingLotId, vehicleType));
    }

    @Test
    void getParkingSpotForVehicleNoCorrectSpot() {
        String parkingLotId = TestConstants.EXISTING_PARKING_LOT_ID;
        String vehicleType = TestConstants.COMPACT_VEHICLE_TYPE;

        when(parkingLotService.findAllParkingSpotsForParkingLot(TestConstants.EXISTING_PARKING_LOT_ID))
                .thenReturn(
                List.of(
                        new RegularParkingSpot(TestConstants.PARKING_LEVEL_1, parkingLotId)
                )
        );

        assertThrows(ParkingLotException.class, () -> {
            bookingService.findParkingSpot(parkingLotId, vehicleType);
        });
    }
}
