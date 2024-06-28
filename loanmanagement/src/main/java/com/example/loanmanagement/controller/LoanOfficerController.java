package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.LoanOfficer;
import com.example.loanmanagement.entity.Report;
import com.example.loanmanagement.entity.ReportType;
import com.example.loanmanagement.service.LoanOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loanofficer")
public class LoanOfficerController {

    @Autowired
    private LoanOfficerService loanOfficerService;

    @PostMapping("/create")
    public LoanOfficer createLoanOfficer(@RequestBody LoanOfficer loanOfficer) {
        return loanOfficerService.createLoanOfficer(loanOfficer);
    }

    @PostMapping("/reports/generate")
    public Report generateReport(@RequestParam Long officerId, @RequestParam ReportType reportType) {
        return loanOfficerService.generateReportForOfficer(officerId, reportType);
    }
}
