package com.lld.exception;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public enum ErrorType {

    NOT_FOUND(404, "Data not found"),
    SOMETHING_WENT_WRONG(500, "Something Went Wrong"),

    ;

    private Integer statusCode;

    @Setter
    private String message;
}
