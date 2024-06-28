package com.example.loanmanagement.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LoanOfficer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;

//    @OneToMany(mappedBy = "loanOfficer", cascade = CascadeType.ALL)
//    private List<LoanApplication> loanApplications = new ArrayList<>();
//
//    @OneToMany(mappedBy = "loanOfficer", cascade = CascadeType.ALL)
//    private List<Report> reports = new ArrayList<>();

    public LoanOfficer() {}

    public LoanOfficer(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public List<LoanApplication> getLoanApplications() {
//        return loanApplications;
//    }
//
//    public void setLoanApplications(List<LoanApplication> loanApplications) {
//        this.loanApplications = loanApplications;
//    }
//
//    public List<Report> getReports() {
//        return reports;
//    }
//
//    public void setReports(List<Report> reports) {
//        this.reports = reports;
//    }

    // Additional methods for LoanOfficer
    public void reviewApplication(LoanApplication application) {
        System.out.println("Reviewing application: " + application.getId());
    }

    public void approveLoan(LoanApplication application) {
        application.setStatus(LoanStatus.APPROVED);
    }

    public void rejectLoan(LoanApplication application) {
        application.setStatus(LoanStatus.REJECTED);
    }

    public Report generateReport(ReportType reportType) {
        Report report = new Report();
        report.setLoanOfficer(this);
        report.setReportType(reportType);
        report.generateContent();
        return report;
    }

    public List<Report> generateReports() {
        List<Report> generatedReports = new ArrayList<>();

        Report monthlyReport = generateReport(ReportType.MONTHLY);
        generatedReports.add(monthlyReport);

        Report annualReport = generateReport(ReportType.ANNUAL);
        generatedReports.add(annualReport);

        Report customReport = generateReport(ReportType.CUSTOM);
        generatedReports.add(customReport);

        return generatedReports;
    }
}
