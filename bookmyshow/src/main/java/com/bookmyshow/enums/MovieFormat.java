package com.bookmyshow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MovieFormat {

    FORMAT_2D("2D"),
    FORMAT_3D("3D"),
    FORMAT_4DX("4DX"),
    FORMAT_IMAX("Imax"),
    ;

    private final String name;
}
