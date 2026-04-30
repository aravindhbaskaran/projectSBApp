package com.aavin.app.factory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aavin.app.enumtypes.PaymentType;
import com.aavin.app.service.PaymentService;

@Component
public class PaymentServiceFactory {

    private final Map<PaymentType, PaymentService> serviceMap;

    public PaymentServiceFactory(List<PaymentService> services) {
        this.serviceMap = services.stream()
                .collect(Collectors.toMap(PaymentService::getType, s -> s));
    }

    public PaymentService getService(PaymentType type) {
        PaymentService service = serviceMap.get(type);
        if (service == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }
        return service;
    }
}