package com.bookmyshow.entity;

import com.lld.entity.AbstractEntity;

public class Booking extends AbstractEntity<Booking> {

    private String userId;
    private String showId;
    private String seatId;

    @Override
    public Booking clone() {
        // TODO
        return null;
    }
}
