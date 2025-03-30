package com.bookmyshow.entity;

import com.lld.entity.AbstractEntity;
import lombok.Getter;

@Getter
public class Theatre extends AbstractEntity<Theatre> {

    private String name;
    private String address;
    private String city;


    @Override
    public Theatre clone() {
        // TODO
        return null;
    }
}
