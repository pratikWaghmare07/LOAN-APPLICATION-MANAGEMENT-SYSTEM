package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.LoanOfficer;
import com.example.loanmanagement.entity.Report;
import com.example.loanmanagement.entity.ReportType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.loanmanagement.repository.LoanOfficerRepository;

@Service
public class LoanOfficerService {

    @Autowired
    private LoanOfficerRepository loanOfficerRepository;

    public LoanOfficer registerLoanOfficer(LoanOfficer loanOfficer) {
        if (loanOfficerRepository.existsByUsername(loanOfficer.getUsername())) {
            throw new IllegalArgumentException("Username is already taken.");
        }
        return loanOfficerRepository.save(loanOfficer);
    }
    public boolean loginLoanOfficer(LoanOfficer loanOfficer) {
        // Implement login logic, e.g., validating username and password
        LoanOfficer existingOfficer = loanOfficerRepository.findByUsername(loanOfficer.getUsername());
        return existingOfficer != null && existingOfficer.getPassword().equals(loanOfficer.getPassword());
    }

    public LoanOfficer createLoanOfficer(LoanOfficer loanOfficer) {
        return loanOfficerRepository.save(loanOfficer);
    }

    public Report generateReportForOfficer(Long officerId, ReportType reportType) {
        // Implement report generation logic
        return new Report();
    }
}
