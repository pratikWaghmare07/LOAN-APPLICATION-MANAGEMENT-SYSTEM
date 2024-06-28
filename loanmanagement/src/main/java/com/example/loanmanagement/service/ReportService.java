package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.Report;
import com.example.loanmanagement.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report generateReport(Report report) {
        report.generateContent(); // Generates content
        return reportRepository.save(report); // Saves and returns the report
    }
}
