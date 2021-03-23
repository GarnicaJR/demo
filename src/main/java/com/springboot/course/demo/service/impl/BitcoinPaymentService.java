package com.springboot.course.demo.service.impl;

import com.springboot.course.demo.service.PaymentService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BitcoinPaymentService implements PaymentService {
    @Override
    public void pay(String accountNumber, double amount){
        System.out.println("Paid by bitcoin account");
    }
}
