package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.Loan;
import com.example.loanmanagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/{loanId}")
    public Loan getLoan(@PathVariable Long loanId) {
        return loanService.getLoanById(loanId);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @PostMapping("/calculateInterest/{loanId}")
    public Loan calculateInterest(@PathVariable Long loanId) {
        return loanService.calculateInterest(loanId);
    }

    @PostMapping("/generateRepaymentSchedule/{loanId}")
    public Loan generateRepaymentSchedule(@PathVariable Long loanId) {
        return loanService.generateRepaymentSchedule(loanId);
    }
}
