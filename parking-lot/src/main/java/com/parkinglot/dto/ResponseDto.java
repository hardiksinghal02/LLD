package com.parkinglot.dto;

public class ResponseDto<T> {
    private T data;
    private boolean success;
    private String errorMessage;

    private ResponseDto(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public ResponseDto<T> success(T data) {
        return new ResponseDto<>(data, true);
    }

    public ResponseDto<T> failure(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}
