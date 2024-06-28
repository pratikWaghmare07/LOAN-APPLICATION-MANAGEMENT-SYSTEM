package com.example.loanmanagement.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FakePaymentService {

    public String createPayment(BigDecimal amount) {
        // Simulate payment processing
        return "Payment of INR " + amount + " processed successfully.";
    }
}
