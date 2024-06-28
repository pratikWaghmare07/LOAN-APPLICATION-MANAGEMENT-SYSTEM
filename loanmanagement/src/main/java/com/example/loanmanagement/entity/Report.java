package com.example.loanmanagement.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date generatedDate;
    private String content;

    @ManyToOne
    @JoinColumn(name = "loan_officer_id")
    private LoanOfficer loanOfficer;

    @Enumerated(EnumType.STRING)
    private ReportType reportType;

    public void generateContent() {
        // Generate content based on the report type
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("Report for Loan Officer: ").append(loanOfficer.getName()).append("\n");
        contentBuilder.append("Report Type: ").append(reportType).append("\n");
        contentBuilder.append("Generated Date: ").append(new Date()).append("\n\n");

//        if (loanOfficer.getLoanApplications() != null) {
//            List<LoanApplication> applications = loanOfficer.getLoanApplications();
//
//            long totalApplications = applications.size();
//            long approvedApplications = applications.stream().filter(app -> app.getStatus() == LoanStatus.APPROVED).count();
//            long rejectedApplications = applications.stream().filter(app -> app.getStatus() == LoanStatus.REJECTED).count();
//            long pendingApplications = applications.stream().filter(app -> app.getStatus() == LoanStatus.PENDING).count();
//
//            contentBuilder.append("Total Applications: ").append(totalApplications).append("\n");
//            contentBuilder.append("Approved Applications: ").append(approvedApplications).append("\n");
//            contentBuilder.append("Rejected Applications: ").append(rejectedApplications).append("\n");
//            contentBuilder.append("Pending Applications: ").append(pendingApplications).append("\n");
//        } else {
//            contentBuilder.append("No applications found for this loan officer.\n");
//        }
//
//        this.content = contentBuilder.toString();
//        this.generatedDate = new Date();
    }

    // Constructors, getters, and setters

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LoanOfficer getLoanOfficer() {
        return loanOfficer;
    }

    public void setLoanOfficer(LoanOfficer loanOfficer) {
        this.loanOfficer = loanOfficer;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }
}
