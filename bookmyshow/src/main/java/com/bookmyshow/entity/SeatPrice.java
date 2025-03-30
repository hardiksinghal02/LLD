package com.bookmyshow.entity;

import com.bookmyshow.enums.SeatType;
import com.lld.entity.AbstractEntity;

import java.math.BigDecimal;

public class SeatPrice extends AbstractEntity<SeatPrice> {

    private String showId;
    private BigDecimal price;
    private SeatType seatType;

    @Override
    public SeatPrice clone() {
        // TODO
        return null;
    }
}
