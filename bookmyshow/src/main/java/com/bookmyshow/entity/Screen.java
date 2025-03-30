package com.bookmyshow.entity;

import com.lld.entity.AbstractEntity;
import lombok.Getter;

@Getter
public class Screen extends AbstractEntity<Screen> {

    private String name;
    private String theatreId;


    @Override
    public Screen clone() {
        return null;
    }
}
