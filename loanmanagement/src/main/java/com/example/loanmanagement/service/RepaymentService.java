package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.Repayment;
import com.example.loanmanagement.repository.RepaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RepaymentService {

    @Autowired
    private RepaymentRepository repaymentRepository;

    public Repayment makePayment(Long repaymentId, BigDecimal amount) {
        Repayment repayment = repaymentRepository.findById(repaymentId).orElse(null);
        if (repayment != null) {
            repayment.makePayment(amount);
            return repaymentRepository.save(repayment);
        }
        return null;
    }

    public Repayment getRepaymentById(Long repaymentId) {
        return repaymentRepository.findById(repaymentId).orElse(null);
    }

    public List<Repayment> getAllRepayments() {
        return repaymentRepository.findAll();
    }
}
