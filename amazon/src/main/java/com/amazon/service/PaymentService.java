package com.amazon.service;

import com.amazon.entity.Order;
import com.amazon.entity.Payment;
import com.amazon.enums.PaymentMethod;

public interface PaymentService {

    // TODO: refine this
    Payment initiatePayment(Order order, PaymentMethod paymentMethod);

    Payment getPaymentStatus(String transactionId);
}
