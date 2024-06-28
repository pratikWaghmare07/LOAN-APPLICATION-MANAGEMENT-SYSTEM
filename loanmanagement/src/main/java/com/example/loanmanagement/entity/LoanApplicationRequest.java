package com.example.loanmanagement.entity;

import java.math.BigDecimal;

public class LoanApplicationRequest {
    private String name;
    private BigDecimal loanAmount;
    private Long borrowerId;
    private Long loanOfficerId;
    
    // Getters and setters (or lombok annotations for simplicity)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Long getLoanOfficerId() {
        return loanOfficerId;
    }

    public void setLoanOfficerId(Long loanOfficerId) {
        this.loanOfficerId = loanOfficerId;
    }
}
