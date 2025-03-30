package com.bookmyshow.entity;

import com.bookmyshow.enums.MovieFormat;
import com.lld.entity.AbstractEntity;

public class Show extends AbstractEntity<Show> {

    private String movieId;
    private String screenId;
    private MovieFormat format;
    private Long startTime;
    private Long endTime;


    @Override
    public Show clone() {
        // TODO
        return null;
    }
}
