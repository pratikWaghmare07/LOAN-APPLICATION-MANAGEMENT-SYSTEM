package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.Report;
import com.example.loanmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generate")
    public Report generateReport(@RequestBody Report report) {
        return reportService.generateReport(report);
    }
}
