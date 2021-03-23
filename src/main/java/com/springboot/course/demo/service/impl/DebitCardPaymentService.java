package com.springboot.course.demo.service.impl;

import com.springboot.course.demo.service.PaymentService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("debitCardPaymentService")
public class DebitCardPaymentService implements PaymentService {


    @Override
    public void pay(String accountNumber, double amount) {

        System.out.println("Paid by debit card account");
    }
}
