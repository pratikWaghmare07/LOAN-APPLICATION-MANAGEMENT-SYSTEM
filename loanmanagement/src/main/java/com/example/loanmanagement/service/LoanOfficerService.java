package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.LoanApplication;
import com.example.loanmanagement.entity.LoanOfficer;
import com.example.loanmanagement.entity.LoanStatus;
import com.example.loanmanagement.entity.Report;
import com.example.loanmanagement.entity.ReportType;
import com.example.loanmanagement.repository.LoanOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanOfficerService {

    @Autowired
    private LoanOfficerRepository loanOfficerRepository;

    public LoanOfficer createLoanOfficer(LoanOfficer loanOfficer) {
        // Perform any necessary validation or business logic here
        return loanOfficerRepository.save(loanOfficer);
    }

    public Report generateReportForOfficer(Long officerId, ReportType reportType) {
        LoanOfficer officer = loanOfficerRepository.findById(officerId).orElseThrow(() -> new RuntimeException("Loan Officer not found"));
        Report report = new Report();
        report.setLoanOfficer(officer);
        report.setReportType(reportType);
        report.generateContent();
        return report;
    }

    public void approveLoan(LoanApplication application) {
        application.setStatus(LoanStatus.APPROVED);
    }

    public void rejectLoan(LoanApplication application) {
        application.setStatus(LoanStatus.REJECTED);
    }
}
