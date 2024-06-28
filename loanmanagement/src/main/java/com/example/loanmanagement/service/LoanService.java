package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.Loan;
import com.example.loanmanagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan getLoanById(Long loanId) {
        return loanRepository.findById(loanId).orElse(null);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan calculateInterest(Long loanId) {
        Loan loan = getLoanById(loanId);
        if (loan != null) {
            // Calculation logic here
            return loanRepository.save(loan);
        }
        return null;
    }

    public Loan generateRepaymentSchedule(Long loanId) {
        Loan loan = getLoanById(loanId);
        if (loan != null) {
            // Generate schedule logic here
            return loanRepository.save(loan);
        }
        return null;
    }
}
