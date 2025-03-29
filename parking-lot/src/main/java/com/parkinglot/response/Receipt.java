package com.parkinglot.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Receipt {
    private final String bookingId;
    private final Double bill;
}
