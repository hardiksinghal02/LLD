package com.parkinglot.exception;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public enum ErrorType {

    NOT_FOUND(404, "Data not found");

    private Integer statusCode;

    @Setter
    private String message;
}
