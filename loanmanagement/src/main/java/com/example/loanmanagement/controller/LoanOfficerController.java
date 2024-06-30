package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.LoanOfficer;
import com.example.loanmanagement.entity.Report;
import com.example.loanmanagement.entity.ReportType;
import com.example.loanmanagement.service.LoanOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loanofficer")
public class LoanOfficerController {

    @Autowired
    private LoanOfficerService loanOfficerService;

    @PostMapping("/register")
    public ResponseEntity<LoanOfficer> registerLoanOfficer(@RequestBody LoanOfficer loanOfficer) {
        LoanOfficer registeredLoanOfficer = loanOfficerService.registerLoanOfficer(loanOfficer);
        return ResponseEntity.ok(registeredLoanOfficer);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginLoanOfficer(@RequestBody LoanOfficer loanOfficer) {
        boolean isLoggedIn = loanOfficerService.loginLoanOfficer(loanOfficer);
        if (isLoggedIn) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/create")
    public LoanOfficer createLoanOfficer(@RequestBody LoanOfficer loanOfficer) {
        return loanOfficerService.createLoanOfficer(loanOfficer);
    }

    @PostMapping("/reports/generate")
    public Report generateReport(@RequestParam Long officerId, @RequestParam ReportType reportType) {
        return loanOfficerService.generateReportForOfficer(officerId, reportType);
    }
}
