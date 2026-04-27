package com.aavin.app.service;

import org.springframework.stereotype.Service;

import com.aavin.app.enumtypes.PaymentType;

@Service("CARD")
public class CreditCardPaymentService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid via Card: " + amount);
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }
}