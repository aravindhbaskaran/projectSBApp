package com.aavin.app.service;

import com.aavin.app.enumtypes.PaymentType;

public interface PaymentService {
    void pay(double amount);
    PaymentType getType();
}