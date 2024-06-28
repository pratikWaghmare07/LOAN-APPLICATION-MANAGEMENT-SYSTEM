package com.example.loanmanagement.service;

import com.example.loanmanagement.entity.*;
import com.example.loanmanagement.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanApplicationService {

    @Autowired
    private LoanApplicationRepository repository;

    public LoanApplication saveLoanApplication(LoanApplication loanApplication) {
        return repository.save(loanApplication);
    }

    public Optional<LoanApplication> getLoanApplicationById(Long id) {
        return repository.findById(id);
    }

    public List<LoanApplication> getAllLoanApplications() {
        return repository.findAll();
    }

    public void deleteLoanApplication(Long id) {
        repository.deleteById(id);
    }
}
