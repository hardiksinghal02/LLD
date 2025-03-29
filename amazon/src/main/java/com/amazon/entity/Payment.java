package com.amazon.entity;

import com.amazon.enums.PaymentMethod;
import com.amazon.enums.PaymentStatus;
import com.lld.entity.AbstractEntity;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Payment extends AbstractEntity<Payment> {
    private String orderId;
    private String transactionId;
    private PaymentStatus paymentStatus;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;

    @Override
    public Payment clone() {

        // TODO
        return null;
    }
}
