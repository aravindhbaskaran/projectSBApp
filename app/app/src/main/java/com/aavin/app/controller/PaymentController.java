package com.aavin.app.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aavin.app.dto.PaymentRequest;
//import com.aavin.app.enumtypes.PaymentType;
//import com.aavin.app.factory.PaymentServiceFactory;
import com.aavin.app.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class PaymentController {
	
	//  using payment factory

//    private final PaymentServiceFactory factory;
//
//    public PaymentController(PaymentServiceFactory factory) {
//        this.factory = factory;
//    }
//
  
	
	//  using map directly
    
    private final Map<String, PaymentService> serviceMap;

    public PaymentController(Map<String, PaymentService> serviceMap) {
        this.serviceMap = serviceMap;
    }
    

    @PostMapping
    public String pay(@RequestBody PaymentRequest request) {
//      PaymentService service = factory.getService(request.getType());
	    PaymentService service = serviceMap.get(request.getType().toUpperCase());
        service.pay(request.getAmount());
        return "Payment successful";
    }

}