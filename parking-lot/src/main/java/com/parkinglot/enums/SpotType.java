package com.parkinglot.enums;

public enum SpotType {
    REGULAR,
    LARGE,
    COMPACT;

    public static SpotType fromName(String name) {
        try {
            return SpotType.valueOf(name.toUpperCase());
        } catch (Exception e) {
            throw new RuntimeException("Invalid spot type : " + name);
        }
    }
}
