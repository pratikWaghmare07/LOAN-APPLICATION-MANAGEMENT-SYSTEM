package com.example.loanmanagement.controller;

import com.example.loanmanagement.entity.*;
import com.example.loanmanagement.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loanApplications")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService service;

    @PostMapping
    public LoanApplication createLoanApplication(@RequestBody LoanApplication loanApplication) {
        return service.saveLoanApplication(loanApplication);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanApplication> getLoanApplicationById(@PathVariable Long id) {
        Optional <LoanApplication> loanApplication = service.getLoanApplicationById(id);
        if (loanApplication.isPresent()) {
            return ResponseEntity.ok(loanApplication.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<LoanApplication> getAllLoanApplications() {
        return service.getAllLoanApplications();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanApplication(@PathVariable Long id) {
        service.deleteLoanApplication(id);
        return ResponseEntity.noContent().build();
    }
}
