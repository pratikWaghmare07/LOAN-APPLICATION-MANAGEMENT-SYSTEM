package com.example.loanmanagement.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Repayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repaymentId;
    private Date dueDate;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private RepaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    // Constructors, getters, and setters

    public Long getRepaymentId() {
        return repaymentId;
    }

    public void setRepaymentId(Long repaymentId) {
        this.repaymentId = repaymentId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public RepaymentStatus getStatus() {
        return status;
    }

    public void setStatus(RepaymentStatus status) {
        this.status = status;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public void makePayment(BigDecimal paymentAmount) {
        if (paymentAmount.compareTo(this.amount) >= 0) {
            this.status = RepaymentStatus.COMPLETED;
            this.amount = BigDecimal.ZERO;
        } else {
            this.status = RepaymentStatus.PENDING;
            this.amount = this.amount.subtract(paymentAmount);
        }
    }
}
