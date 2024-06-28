package com.example.loanmanagement.entity;



import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private Integer loanTerm;
    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repayment> repaymentSchedule;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(Integer loanTerm) {
        this.loanTerm = loanTerm;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public List<Repayment> getRepaymentSchedule() {
        return repaymentSchedule;
    }

    public void setRepaymentSchedule(List<Repayment> repaymentSchedule) {
        this.repaymentSchedule = repaymentSchedule;
    }

    public BigDecimal calculateInterest() {
        return loanAmount.multiply(interestRate).divide(new BigDecimal(100));
    }

    public void generateRepaymentSchedule() {
        for (int i = 1; i <= loanTerm; i++) {
            Repayment repayment = new Repayment();
            repayment.setLoan(this);
            repayment.setDueDate(new Date(startDate.getTime() + (long) i * 30 * 24 * 60 * 60 * 1000));
            repayment.setAmount(loanAmount.divide(new BigDecimal(loanTerm), BigDecimal.ROUND_HALF_UP));
            repayment.setStatus(RepaymentStatus.PENDING);
            repaymentSchedule.add(repayment);
        }
    }
}
