package com.aavin.app.service;

import org.springframework.stereotype.Service;

import com.aavin.app.enumtypes.PaymentType;

@Service("UPI")
public class UPIPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid via UPI: " + amount);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.UPI;
    }
}