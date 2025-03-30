package com.bookmyshow.entity;

import com.bookmyshow.enums.SeatType;
import com.lld.entity.AbstractEntity;
import lombok.Getter;

@Getter
public class Seat extends AbstractEntity<Seat> {

    private String screenId;
    private String position;
    private SeatType seatType;


    @Override
    public Seat clone() {
        // TODO
        return null;
    }
}
