package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.Repayment;
import com.example.loanmanagement.service.FakePaymentService;
import com.example.loanmanagement.service.RepaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/repayments")
public class RepaymentController {

    @Autowired
    private RepaymentService repaymentService;

    @Autowired
    private FakePaymentService fakePaymentService;

    @PostMapping("/{repaymentId}/makePayment")
    public ResponseEntity<?> makePayment(@PathVariable Long repaymentId, @RequestParam BigDecimal paymentAmount) {
        Repayment repayment = repaymentService.getRepaymentById(repaymentId);

        if (repayment == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            // Simulate payment processing with FakePaymentService
            String paymentResult = fakePaymentService.createPayment(paymentAmount);
            Repayment updatedRepayment = repaymentService.makePayment(repaymentId, paymentAmount);
            return ResponseEntity.ok(updatedRepayment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{repaymentId}")
    public ResponseEntity<Repayment> getRepaymentById(@PathVariable Long repaymentId) {
        Repayment repayment = repaymentService.getRepaymentById(repaymentId);
        if (repayment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repayment);
    }
}
